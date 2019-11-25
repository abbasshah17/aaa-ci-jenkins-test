package com.example.jenkins_ci_test.domain.repository;

public interface Repository<ReturnType> {
    ReturnType load();
}
