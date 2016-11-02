package mx.foodstack.spring.dagger;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import mx.foodstack.menu.entityBoundaries.IMenuRepository;
import mx.foodstack.spring.HomeUseCases;

/**
 * Created by eecheverria on 11/1/2016.
 */

@Module
public class UseCaseModule {
    private IMenuRepository mMenuRepository;

    @Inject String abc;

    public UseCaseModule(IMenuRepository menuRepository) {
        mMenuRepository = menuRepository;
    }

    @Provides
    public HomeUseCases provideHomeUseCases() {
        System.out.println(abc);
        return new HomeUseCases(mMenuRepository);
    }
}