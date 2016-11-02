package mx.foodstack.spring.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.foodstack.menu.entityBoundaries.IMenuRepository;
import mx.foodstack.menu.repositories.MenuRepository;

/**
 * Created by eecheverria on 11/1/2016.
 */

@Module
public class RepositoryModule {
    @Provides
    @Singleton
    public IMenuRepository provideMenuRepository() {
        return new MenuRepository();
    }

    @Provides
    public String provideAbc() {return "ABC"; }
}