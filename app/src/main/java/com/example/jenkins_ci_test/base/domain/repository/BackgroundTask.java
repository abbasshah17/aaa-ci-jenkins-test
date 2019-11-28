package com.example.jenkins_ci_test.base.domain.repository;

import android.os.AsyncTask;

/**
 * Built on top of the {@link Task} {@code interface}, the {@link BackgroundTask} provides an easier
 * way to execute the main code on the Background Thread abstracting the boiler-plate code.
 * */
public abstract class BackgroundTask<T> extends AsyncTask<Object, Void, T> implements Task<T> {

    private static final String TAG = "BackgroundTask";

    private ResultCallback<T> mCallback;


    public void runBackground()
    {
        if (super.getStatus() == Status.PENDING) {
            execute();
        }
    }

    /**
     * Set {@link ResultCallback} to be notified whenever the {@link Task} is completed.
     * Note that {@link BackgroundTask#onComplete(Object)} is called before the callback.
     *
     * @param callback the callback object reference to notify task completion.
     * */
    @Override
    public void setCallback(ResultCallback<T> callback)
    {
        mCallback = callback;
    }

    /**
     * Called whenever the {@link Task} is completed and is no longer running. Child
     * {@code classes} can use this method to clear up any resources they were holding on to.
     *
     * <p>
     *     Is always called on the Main-Thread.
     * </p>
     *
     * @param result the result of the {@link Task} which must be provided as {@link Task}'s
     * {@code Type}.
     * */
    protected abstract void onComplete(T result);

    @Override
    protected final T doInBackground(Object... params)
    {
        if (isCancelled()) {
            return null;
        }

        return run();
    }

    @Override
    public final void onPostExecute(T result)
    {
        if (isCancelled()) {
            return;
        }

        onComplete(result);

        if (isCancelled()) {
            return;
        }

        notifyTaskComplete(result);
    }

    /**
     * Stops the execution of the current {@link Task}.
     * */
    @Override
    public void stop()
    {
        cancel(true);
    }

    private void notifyTaskComplete(T result)
    {
        if (mCallback != null) {
            mCallback.onResult(result);
        }
    }
}
