package com.example.jenkins_ci_test.login.views;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.jenkins_ci_test.R;
import com.example.jenkins_ci_test.base.domain.models.login.LoginResponseModel;
import com.example.jenkins_ci_test.base.domain.repository.Repository;
import com.example.jenkins_ci_test.jenkins_ci_test.app.JCITApplication;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.FileOutputStream;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityAndroidTest {

    private static final String TAG = "LoginActivityAndroidTes";

    private static final String SUCCESS_MESSAGE = "Login successful";
    private static final String FAILURE_MESSAGE = "Email not valid";

    private static final String VALID_USERNAME = "abbasshah17@gmail.com";
    private static final String VALID_PASSWORD = "12345678";

    /*private String [] credentials = {
            "abbasshah17@gmail.com", "12345678", SUCCESS_MESSAGE,
            "abbasshah17@gmail.com", "123", SUCCESS_MESSAGE,
            "abbasshah17@gmail.com", "12345678901234567890", SUCCESS_MESSAGE,
            "abbasshah17@gmail.com", "", SUCCESS_MESSAGE,
            "abbasshah17@gmail.com", null, SUCCESS_MESSAGE,
            "123@gmail.com", "12345678", FAILURE_MESSAGE,
            "123@gmail.com", "", FAILURE_MESSAGE,
            "123@gmail.com", null, FAILURE_MESSAGE,
            "ABC@gmail.com", "123456678", FAILURE_MESSAGE,
            "ABC@gmail.com", null, FAILURE_MESSAGE,
            "ABC@gmail", "12345678", FAILURE_MESSAGE,
            "ABC@gmail", "1234", FAILURE_MESSAGE,
            "ABC@gmail", "12345678901234567890", FAILURE_MESSAGE,
            "ABC@gmail", null, FAILURE_MESSAGE,
            "ABC", "12345678", FAILURE_MESSAGE,
            "ABC", "123", FAILURE_MESSAGE,
            "ABC", "12345678901234567890", FAILURE_MESSAGE,
            "ABC", null, FAILURE_MESSAGE,
            null, null, FAILURE_MESSAGE
    };*/

//    @Rule
//    public ActivityScenarioRule<LoginActivity> rule;

    @Rule public ActivityScenarioRule<LoginActivity> activityScenarioRule
            = new ActivityScenarioRule<>(LoginActivity.class);


    @Before
    public void initialize()
    {
    }

    @Test
    public void doesUsernameAndPasswordMatch()
    {
        try {
            onView(withId(R.id.input_email))
                    .perform(typeText(VALID_USERNAME), closeSoftKeyboard());

            onView(withId(R.id.input_password))
                    .perform(typeText(VALID_PASSWORD), closeSoftKeyboard());

            onView(withId(R.id.login_button)).perform(click());

            Thread.sleep(2000);

            onView(withId(R.id.loginStatus)).check(matches(withText(SUCCESS_MESSAGE)));
        }
        catch (Exception ex) {
            ex.printStackTrace();

            fail(ex.getMessage());
        }
    }
}