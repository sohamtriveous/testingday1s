package cc.soham.espresso_1_3_1;

import static android.support.test.espresso.action.ViewActions.*;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.PositionAssertions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InstrumentedTest_1_4 {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void enterRightUsernameAndPassword_clickSubmit_goesToNextPage() {
        onView(withId(R.id.activity_main_username)).check(matches(isDisplayed())).perform(typeText("hello"));
        onView(withId(R.id.activity_main_password)).check(matches(isDisplayed())).perform(typeText("world"));
        onView(withId(R.id.activity_main_submit)).perform(click());
        onView(withText("success")).check(matches(isDisplayed()));
    }

    @Test
    public void enterWrongUsernameAndPassword_clickSubmit_doesNotGoToNextPage() {
        onView(withId(R.id.activity_main_username)).check(matches(isDisplayed())).perform(typeText("soham"));
        onView(withId(R.id.activity_main_password)).check(matches(isDisplayed())).perform(typeText("world"));
        onView(withId(R.id.activity_main_submit)).perform(click());
        onView(withText("success")).check(doesNotExist());
    }

    @Test
    public void enterUsernameAndPassword_clickResets_resetsUsernameAndPassword() {
        onView(withId(R.id.activity_main_username)).check(matches(isDisplayed())).perform(typeText("hello"));
        onView(withId(R.id.activity_main_password)).check(matches(isDisplayed())).perform(typeText("world"));
        onView(withId(R.id.activity_main_reset)).perform(click());

        onView(withId(R.id.activity_main_username)).check(matches(withText("")));
        onView(withId(R.id.activity_main_password)).check(matches(withText("")));
        onView(withText("success")).check(doesNotExist());
    }

}
