package mx.foodstack.spring.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by eecheverria on 11/2/2016.
 */

@Scope
@Documented
@Retention(value = RUNTIME)
public @interface ActivityScope {
}