package mx.foodstack.spring.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by eecheverria on 11/2/2016.
 */

@Singleton
@Component(modules = {UseCaseModule.class, RepositoryModule.class})
public interface IRepositoryComponent {
}