package com.example.jenkins_ci_test.base.domain.repository;

import java.util.Random;

public class SalutationsRepository<Type> implements Repository<Type> {

    private Random randomNumberGenerator;

    private String [] salutations = {
            "Hello World",
            "Hello Everyone",
            "Hi!",
            "How you doin'"
    };

    public SalutationsRepository()
    {
        randomNumberGenerator = new Random();
    }

    @Override
    public Type load()
    {
        String salutation;

        int random = Math.abs(randomNumberGenerator.nextInt());

        salutation = salutations[random % 4];

        return (Type) salutation;
    }
}
