package mx.foodstack.spring.dagger;

import javax.inject.Singleton;

import dagger.Component;
import mx.foodstack.spring.MainActivity;

/**
 * Created by eecheverria on 11/1/2016.
 */

@ActivityScope
@Component(dependencies = IRepositoryComponent.class, modules = {AppModule.class, UseCaseModule.class})
public interface IUseCaseComponent {
    void inject(MainActivity activity);
}