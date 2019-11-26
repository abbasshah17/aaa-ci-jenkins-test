package com.example.jenkins_ci_test.jenkins_ci_test.di.component;

import com.example.jenkins_ci_test.jenkins_ci_test.di.modules.JCITModule;
import com.example.jenkins_ci_test.jenkins_ci_test.di.scopes.JcitScope;
import com.example.jenkins_ci_test.login.di.components.LoginComponent;
import com.example.jenkins_ci_test.network.di.modules.RetrofitModule;

import dagger.Component;

@JcitScope
@Component(
        modules = {
                JCITModule.class,
                RetrofitModule.class
        }
)
public interface JCITComponent {

    LoginComponent.Builder getLoginComponentBuilder();


    @Component.Builder
    interface Builder {
//        Builder setJcitModule(JCITModule module);

        JCITComponent build();
    }
}
