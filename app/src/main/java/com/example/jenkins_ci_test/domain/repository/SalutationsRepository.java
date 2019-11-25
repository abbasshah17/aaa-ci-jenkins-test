package com.example.jenkins_ci_test.domain.repository;

public class SalutationsRepository<Type> implements Repository<Type> {

    private String [] salutations = {
            "Hello World",
            "Hello Everyone",
            "Hi!",
            "How you doin'"
    };

    @Override
    public Type load()
    {
        String salutation;

        double random = Math.random();

        salutation = salutations[(int) (random % 4)];

        return (Type) salutation;
    }
}
