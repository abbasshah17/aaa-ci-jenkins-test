package com.example.jenkins_ci_test.base.domain.usecase;

import android.os.AsyncTask;

public abstract class BackgroundTask<T> extends AsyncTask<Object, Void, T> implements Task<T> {

    protected ResultCallback<T> mCallback;


    public void runBackground()
    {
        execute();
    }

    public void setCallback(ResultCallback callback)
    {
        mCallback = callback;
    }

    //  Perform clean up.
    protected abstract void onComplete(T result);

    @Override
    protected final T doInBackground(Object... params)
    {
        return run();
    }

    @Override
    public final void onPostExecute(T result)
    {
        onComplete(result);

        notifyTaskComplete(result);
    }

    private void notifyTaskComplete(T result)
    {
        if (mCallback != null) {
            mCallback.onResult(result);
        }
    }

    public interface ResultCallback<T> {
        void onResult(T result);
    }
}
