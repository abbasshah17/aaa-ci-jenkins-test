package com.example.jenkins_ci_test.base.domain.repository;

public interface Repository<ReturnType> {
    ReturnType load();
}
