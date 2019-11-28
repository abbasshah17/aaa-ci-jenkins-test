package com.example.jenkins_ci_test.login.di.names;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface LivePasswordKey {

    /** The name. */
    String value() default "LivePasswordKey";
}
