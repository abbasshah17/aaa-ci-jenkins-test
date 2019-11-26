package com.example.jenkins_ci_test.base.vm;

import androidx.lifecycle.MutableLiveData;

import com.example.jenkins_ci_test.base.domain.usecase.HelloUseCase;

public class HelloViewModel extends BaseViewModel implements HelloUseCase.HelloUseCaseCallback {

    private MutableLiveData<String> salutation;

    private HelloUseCase salutationsLoadingUseCase;

    public HelloViewModel()
    {
        setSalutation("Starting");

        salutationsLoadingUseCase = new HelloUseCase();
        salutationsLoadingUseCase.setCallback(this);
    }

    public void loadNextSalutation()
    {
        salutationsLoadingUseCase.runAsync();
    }

    public void setSalutation(String salutation)
    {
        if (this.salutation == null) {
            this.salutation = new MutableLiveData<>();
        }

        this.salutation.postValue(salutation);
    }

    public MutableLiveData<String> getSalutation()
    {
        return salutation;
    }

    @Override
    public void onSalutationLoaded(String salutation)
    {
        setSalutation(salutation);
    }
}
