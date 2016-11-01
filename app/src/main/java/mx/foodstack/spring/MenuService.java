package mx.foodstack.spring;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by eecheverria on 10/22/2016.
 */

public class MenuService extends IntentService {
    public static final String TAG = "MenuService";
    public static final String KEY = "foodstack_menu";

    public MenuService() {
        super(TAG);
    }

    private static void writeObject(Context context, String key, Object object) throws IOException {
        FileOutputStream fos = context.openFileOutput(key, Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        fos.close();
    }

    private static Menu readObject(Context context, String key) throws IOException,
            ClassNotFoundException {
        if (!fileExists(context, key))
            return null;

        FileInputStream fis = context.openFileInput(key);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return  (Menu)ois.readObject();
    }

    private static boolean fileExists(Context context, String key) {
        File file = context.getFileStreamPath(key);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Menu menu = null;

        try {
            menu = readObject(this, KEY);
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        if (menu != null) {
            System.out.println("Retrieved menu from local storage: ");
            return;
        }


        //String dataString = intent.getDataString();
        Menu[] menus;

        try {
            final String url = "https://preview.c9users.io/eddiemachete/mixpanel/apple/menus.1.json";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            menus = restTemplate.getForObject(url, mx.foodstack.spring.Menu[].class);
        } catch (Exception e) {
            menus = new Menu[0];
            Log.e("MainActivity", e.getMessage(), e);
        }

        System.out.println("Got menus " + Integer.toString(menus.length));

        if (menus.length > 0) {
            try {
                writeObject(this, KEY, menus[0]);
            } catch (Exception ex) {
                Log.e("MainActivity", ex.getMessage(), ex);
            }
        }

        // Reports that the feed retrieval is complete.
        //mBroadcaster.broadcastIntentWithState(Constants.STATE_ACTION_COMPLETE);

        Intent localIntent =
                new Intent(Constants.BROADCAST_ACTION)
                        .putExtra(Constants.EXTENDED_DATA_STATUS, "Completed");
        // Broadcasts the Intent to receivers in this app.
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }

    public Menu[] getMenus() throws InterruptedException, ExecutionException {
        ExecutorService exService = Executors.newSingleThreadExecutor();
        FutureTask<Menu[]> futureTask= new FutureTask<Menu[]>(new GetMenusTask());
        exService.execute(futureTask);

        //fetches result and waits if not ready
        System.out.println(futureTask.get());

        return futureTask.get();
    }

    private Menu[] mMenus;


    private class GetMenusTask implements Callable<Menu[]> {
        public Menu[] call() {
            HttpRequestMenuTask task  = new HttpRequestMenuTask();
            task.execute();

            /*Menu[] menus;

            try {
                task.execute();
                //menus = task.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                menus = new Menu[0];
            }

            return menus;*/

            return mMenus;
        }
    }

    private class HttpRequestMenuTask extends AsyncTask<Void, Void, mx.foodstack.spring.Menu[]> {
        @Override
        protected mx.foodstack.spring.Menu[] doInBackground(Void... params) {
            try {
                final String url = "https://preview.c9users.io/eddiemachete/mixpanel/apple/menus.json";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                mx.foodstack.spring.Menu[] menus = restTemplate.getForObject(url, mx.foodstack.spring.Menu[].class);
                return menus;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return new mx.foodstack.spring.Menu[0];
        }

        @Override
        protected void onPostExecute(mx.foodstack.spring.Menu[] menus) {
            mMenus = menus;
        }
    }
}
