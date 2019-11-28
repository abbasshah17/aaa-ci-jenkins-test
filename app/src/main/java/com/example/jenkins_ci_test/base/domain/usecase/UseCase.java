package com.example.jenkins_ci_test.base.domain.usecase;

import android.util.Log;

import com.example.jenkins_ci_test.base.domain.repository.Task;

import java.util.List;

import javax.inject.Inject;

public abstract class UseCase <T> {

    private static final String TAG = "UseCase";

    private Callback<T> mCallback;

    @Inject
    List<Task> tasks;


    public UseCase()
    {
    }

    public void subscribe(Callback<T> callback)
    {
        mCallback = callback;
    }

    protected void addTask(Task task)
    {
        if (tasks == null) {
            Log.e(TAG, "addTask: tasks is null. Dagger has not injected List<Tasks>");
            return;
        }

        tasks.add(task);
    }

    protected void notifyComplete(T result)
    {
        if (mCallback != null) {
            mCallback.onComplete(result);
        }
    }

    protected void cancelTasks()
    {
        for (Task task : tasks) {
            task.stop();
        }
    }

    public void clear()
    {
        cancelTasks();
    }

    public interface Callback<T> {
        void onComplete(T result);
    }
}
