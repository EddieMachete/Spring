package mx.foodstack.spring;

import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by eecheverria on 10/26/2016.
 */

public class MenuRepository {
    private final ExecutorService mPool = Executors.newFixedThreadPool(10);

    public Future<Menu[]> getMenus() {
        return mPool.submit(new Callable<Menu[]>() {
            @Override
            public Menu[] call() {
                Menu[] menus;

                try {
                    final String url = "https://preview.c9users.io/eddiemachete/mixpanel/apple/menus.json";
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    menus = restTemplate.getForObject(url, mx.foodstack.spring.Menu[].class);
                } catch (Exception e) {
                    menus = new Menu[0];
                    Log.e("MainActivity", e.getMessage(), e);
                }

                return menus;
            }
        });
    }
}