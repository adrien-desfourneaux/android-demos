/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Adrien Desfourneaux
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.dieze.androiddemos.navigation.test.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.FailureHandler;
import android.support.test.espresso.base.DefaultFailureHandler;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.dieze.androiddemos.navigation.MainActivity;
import com.dieze.androiddemos.navigation.R;

import junit.framework.AssertionFailedError;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.setFailureHandler;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.LAYOUT_ID;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.close;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.navigateTo;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.navigateToAtName;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.navigateToAtPosition;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.navigateUp;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.open;
import static com.dieze.androiddemos.navigation.test.utils.ToolbarUtils.checkTitleDisplayed;
import static com.dieze.androiddemos.navigation.utils.DrawerUtils.getItemViewIdAtPosition;

/**
 * Tests for the Drawer test utils.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class DrawerUtilsTest {

    /**
     * A custom Espresso FailureHandler to allow testing of failures.
     *
     * @see <a href="https://google.github.io/android-testing-support-library/docs/espresso/advanced/#using-a-custom-failure-handler">Using a custom failure handler</a>
     */
    private static class CustomFailureHandler implements FailureHandler {
        /**
         * Delegate FailureHandler to which we will delegate error handling.
         */
        private final FailureHandler mDelegate;

        /**
         * A JUnit TestName instance that contains the name of the current test method.
         */
        private final TestName mTestName;

        public CustomFailureHandler(Context targetContext, TestName testName) {
            mDelegate = new DefaultFailureHandler(targetContext);
            mTestName = testName;
        }

        /**
         * Handle the given error.
         *
         * There are known conditions where we have to do nothing when the error occurs.
         */
        @Override
        public void handle(Throwable error, Matcher<View> viewMatcher) {
            try {
                mDelegate.handle(error, viewMatcher);
            } catch (AssertionFailedError e) {
                if (mTestName.getMethodName().equals("testOpen_drawerOpen") && e.getMessage().contains("is drawer closed")) {} // do nothing
                else if (mTestName.getMethodName().equals("testClose_drawerClosed") && e.getMessage().contains("is drawer open")) {} // do nothing
                else {
                    throw e;
                }
            }
        }
    }

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
     * The TestName Rule makes the current test name available inside test methods.
     */
    @Rule public TestName testName = new TestName();

    @Before
    public void setCustomFailureHandler() {
        setFailureHandler(new CustomFailureHandler(InstrumentationRegistry.getTargetContext(), testName));
    }

    /**
     * Test #open().
     */
    @Test
    public void testOpen() {
        open();

        onView(withId(LAYOUT_ID))
                .check(matches(isOpen()));
    }

    /**
     * Test #open() with drawer previously opened.
     *
     * @see CustomFailureHandler#handle handle
     */
    @Test
    public void testOpen_drawerOpen() {
        open();
        open();
    }

    /**
     * Test #close().
     */
    @Test
    public void testClose() {
        open();
        close();

        onView(withId(LAYOUT_ID))
                .check(matches(isClosed()));
    }

    /**
     * Test #close() with non open drawer.
     */
    @Test
    public void testClose_drawerClosed() {
        close();
    }

    /**
     * Test #navigateToAtPosition.
     */
    @Test
    public void testNavigateToAtPosition() {
        navigateToAtPosition(mMainActivityTestRule.getActivity().getDrawer(), 1);
        ToolbarUtils.checkTitleDisplayed(R.string.master_fragment_2_title);
    }

    /**
     * Test #navigateTo.
     */
    @Test
    public void testNavigateTo() {
        navigateTo(getItemViewIdAtPosition(mMainActivityTestRule.getActivity().getDrawer(), 1));
        ToolbarUtils.checkTitleDisplayed(R.string.master_fragment_2_title);
    }

    /**
     * Test #navigateToAtName(int).
     */
    @Test
    public void testNavigateToAtName_int() {
        navigateToAtName(R.string.master_fragment_2_title);
        ToolbarUtils.checkTitleDisplayed(R.string.master_fragment_2_title);
    }

    /**
     * Test #navigateToAtName(String).
     */
    @Test
    public void testNavigateToAtName_string() {
        String name = mMainActivityTestRule.getActivity().getString(R.string.master_fragment_2_title);

        navigateToAtName(name);
        ToolbarUtils.checkTitleDisplayed(R.string.master_fragment_2_title);
    }

    /**
     * Test #navigateUp(Toolbar).
     */
    @Test
    public void testNavigateUp() {
        navigateToAtName(R.string.master_fragment_1_title);
        ToolbarUtils.checkTitleDisplayed(R.string.master_fragment_1_title);

        onView(withId(R.id.button_detail)).perform(click());
        ToolbarUtils.checkTitleDisplayed(R.string.detail_fragment_1_1_title);

        navigateUp(mMainActivityTestRule.getActivity().getActionBarToolbar());
        ToolbarUtils.checkTitleDisplayed(R.string.master_fragment_1_title);
    }
}
