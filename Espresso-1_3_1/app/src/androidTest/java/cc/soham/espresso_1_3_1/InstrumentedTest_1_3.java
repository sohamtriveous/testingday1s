package cc.soham.espresso_1_3_1;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.PositionAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InstrumentedTest_1_3 {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void isUserNameEditTextVisible() {
        onView(withId(R.id.activity_main_username)).check(matches(isDisplayed()));
    }

    @Test
    public void isPasswordEditTextVisible() {
        onView(withId(R.id.activity_main_password)).check(matches(isDisplayed()));
    }

    @Test
    public void isUserNameEditTextVisible_viaHint() {
        onView(withHint("username")).check(matches(isDisplayed()));
    }

    @Test
    public void isPasswordEditTextVisible_viaHint() {
        onView(withHint("password")).check(matches(isDisplayed()));
    }

    @Test
    public void isSubmitButtonVisible() {
        onView(withId(R.id.activity_main_submit)).check(matches(isDisplayed()));
    }

    @Test
    public void isResetButtonVisible() {
        onView(withId(R.id.activity_main_reset)).check(matches(isDisplayed()));
    }

    @Test
    public void isSubmitButtonVisible_viaText() {
        onView(withText("submit")).check(matches(isDisplayed()));
    }

    @Test
    public void isResetButtonVisible_viaText() {
        onView(withText("submit")).check(matches(isDisplayed()));
    }

    @Test
    public void isSubmitButtonBelowPassword() {
        onView(withText("submit")).check(PositionAssertions.isCompletelyBelow(withHint("password")));
    }

    @Test
    public void isSubmitButtonBelowUsername() {
        onView(withText("submit")).check(PositionAssertions.isCompletelyBelow(withHint("username")));
    }
}
