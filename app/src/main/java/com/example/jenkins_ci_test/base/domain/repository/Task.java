package com.example.jenkins_ci_test.base.domain.repository;

/**
 * A Task is a single operation that needs to performed.
 * */
public interface Task<T> {

    /**
     * Set {@link Task.ResultCallback} to be notified whenever the {@link Task} is completed.
     *
     * @param callback the callback object reference to notify task completion.
     * */
    void setCallback(BackgroundTask.ResultCallback<T> callback);

    /**
     * The place for the {@link Task} to run its process.
     *
     * The method is called on whichever thread called it.
     * */
    T run();

    /**
     * Cancels and eventually stops all running {@link Task}s.
     *
     * <p>
     *     The subscriber may or may not receive the callback depending on how far along in the
     *     executions process the {@link Task} was.
     * </p>
     * */
    void stop();

    interface ResultCallback<T> {
        void onResult(T result);
    }
}
