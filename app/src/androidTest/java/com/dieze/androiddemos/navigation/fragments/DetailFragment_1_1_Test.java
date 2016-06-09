package com.dieze.androiddemos.navigation.fragments;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.Toolbar;

import com.dieze.androiddemos.navigation.MainActivity;
import com.dieze.androiddemos.navigation.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.navigateToAtName;
import static com.dieze.androiddemos.navigation.test.utils.ToolbarUtils.checkTitleDisplayed;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.navigateUp;

/**
 * DetailFragment_1_1 UI tests.
 */
public class DetailFragment_1_1_Test {

    /**
     * Provides functional testing of a single activity.
     *
     * The activity under test will be launched before each test annotated with Test and before
     * methods annotated with Before. It will be terminated after the test is completed and methods
     * annotated with After are finished.
     *
     * During the duration of the test we will be able to manipulate the Activity directly.
     */
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    /**
     * Get the ActionBar Toolbar of the MainActivity under test.
     */
    private Toolbar getToolbar() {
        return mMainActivityTestRule.getActivity().getActionBarToolbar();
    }

    /**
     * The first master fragment must be shown on activity creation for this to work.
     */
    @Before
    public void navigateToDetailFragment_1_1() {
        onView(withId(R.id.button_detail)).perform(click());
        checkTitleDisplayed(R.string.detail_fragment_1_1_title);
    }

    /**
     * Navigate to the parent fragment via the navigate up button.
     */
    @Test
    public void testNavigateUp() {
        navigateUp(getToolbar());
        checkTitleDisplayed(R.string.master_fragment_1_title);
    }

    /**
     * Navigate to the first master fragment via the drawer.
     */
    @Test
    public void navigateToMasterFragment_1() {
        navigateToAtName(R.string.master_fragment_1_title);
        checkTitleDisplayed(R.string.master_fragment_1_title);
    }

    /**
     * Navigate to the second master fragment via the drawer.
     */
    @Test
    public void navigateToMasterFragment_2() {
        navigateToAtName(R.string.master_fragment_2_title);
        checkTitleDisplayed(R.string.master_fragment_2_title);
    }

    /**
     * Navigate to the first detail fragment and navigate up.
     */
    @Test
    public void navigateToDetailFragment_1_1_1() {
        onView(withId(R.id.button_detail_1)).perform(click());
        checkTitleDisplayed(R.string.detail_fragment_1_1_1_title);

        navigateUp(getToolbar());
        checkTitleDisplayed(R.string.detail_fragment_1_1_title);
    }

    /**
     * Navigate to the second detail fragment and navigate up.
     */
    @Test
    public void navigateToDetailFragment_1_1_2() {
        onView(withId(R.id.button_detail_2)).perform(click());
        checkTitleDisplayed(R.string.detail_fragment_1_1_2_title);

        navigateUp(getToolbar());
        checkTitleDisplayed(R.string.detail_fragment_1_1_title);
    }
}
