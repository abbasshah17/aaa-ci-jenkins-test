package com.example.jenkins_ci_test.base.domain.usecase;

import com.example.jenkins_ci_test.base.domain.repository.Repository;
import com.example.jenkins_ci_test.base.domain.repository.SalutationsRepository;

public class HelloUseCase extends UseCase<String> {

    private HelloUseCaseCallback mCallback;
    private Repository<String> repository = new SalutationsRepository<>();

    public HelloUseCase()
    {   }


    public void setCallback(HelloUseCaseCallback callback)
    {
        mCallback = callback;
    }

    @Override
    public String run()
    {
        return repository.load();
    }

    @Override
    protected void respond(String response)
    {
        if (mCallback != null) {
            mCallback.onSalutationLoaded(response);
        }
    }

    public interface HelloUseCaseCallback {
        void onSalutationLoaded(String salutation);
    }
}
