package cc.soham.recyclerviewtest;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by sohammondal on 03/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class ListViewTest {
    @Rule
    public ActivityTestRule<ListViewActivity> rule = new ActivityTestRule<ListViewActivity>(ListViewActivity.class);

    @Test
    public void firstItem_isVisible()  {
        onView(withText("item: 0")).check(matches(isDisplayed()));
    }

    @Test
    public void lastItem_wasNotVisible()  {
        onView(withText("item: 99")).check(ViewAssertions.doesNotExist());
    }

    @Test
    public void lastItem_wasVisibleWhenScrolled()  {
        onData(hasEntry(Matchers.equalTo(ListViewActivity.ROW_TEXT), is("item: 99"))).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void lastItem_itemClicked()  {
        onData(hasEntry(Matchers.equalTo(ListViewActivity.ROW_TEXT), is("item: 99")))
                .onChildView(withId(R.id.rowContentTextView))
                .perform(click());
    }

    @Test
    public void firstItem_itemClicked()  {
        onData(hasEntry(Matchers.equalTo(ListViewActivity.ROW_TEXT), is("item: 0")))
                .onChildView(withId(R.id.rowContentTextView))
                .perform(click());
    }

    @Test
    public void toggle_Click() {
        // Click on a toggle button.
        onRow("item: 0").onChildView(withId(R.id.rowToggleButton)).perform(click());

        // Check that the toggle button is checked.
        onRow("item: 0").onChildView(withId(R.id.rowToggleButton)).check(matches(isChecked()));
    }

    private static DataInteraction onRow(String str) {
        return onData(hasEntry(equalTo(ListViewActivity.ROW_TEXT), is(str)));
    }
}
