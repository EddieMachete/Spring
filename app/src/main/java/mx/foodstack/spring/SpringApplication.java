package mx.foodstack.spring;

import android.app.Application;

import mx.foodstack.menu.entityBoundaries.IMenuRepository;
import mx.foodstack.menu.repositories.MenuRepository;
import mx.foodstack.spring.dagger.AppModule;
//import mx.foodstack.spring.dagger.DaggerIRepositoryComponent;
import mx.foodstack.spring.dagger.DaggerIRepositoryComponent;
import mx.foodstack.spring.dagger.DaggerIUseCaseComponent;
import mx.foodstack.spring.dagger.IRepositoryComponent;
import mx.foodstack.spring.dagger.IUseCaseComponent;
import mx.foodstack.spring.dagger.UseCaseModule;

/**
 * Created by eecheverria on 11/1/2016.
 */

public class SpringApplication extends Application {
    private IMenuRepository mMenuRepository;
    private IUseCaseComponent mUseCaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Dagger injections
        mMenuRepository = new MenuRepository();

        IRepositoryComponent repositoryComponent = DaggerIRepositoryComponent.create();

        mUseCaseComponent = DaggerIUseCaseComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .useCaseModule(new UseCaseModule(mMenuRepository))
                .iRepositoryComponent(repositoryComponent)
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mNetComponent = com.codepath.dagger.components.DaggerNetComponent.create();

        // if it provides a constructor:
        // mNetComponent = DaggerNetComponent.builder()
        //        .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
        //        .netModule(new NetModule("https://api.github.com"))
        //        .build();
    }

    public IUseCaseComponent getUseCaseComponent() {
        return mUseCaseComponent;
    }

    public HomeUseCases getHomeUseCases() {
        return new HomeUseCases(mMenuRepository);
    }
}
