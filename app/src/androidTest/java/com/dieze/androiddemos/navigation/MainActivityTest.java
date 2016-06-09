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

package com.dieze.androiddemos.navigation;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.navigateToAtName;
import static com.dieze.androiddemos.navigation.test.utils.DrawerUtils.navigateUp;
import static com.dieze.androiddemos.navigation.test.utils.ToolbarUtils.checkTitleDisplayed;

/**
 * MainActivity UI tests.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

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
            new ActivityTestRule<MainActivity>(MainActivity.class);

    /**
     * Test that the Activity is initialized with the first Master fragment.
     */
    @Test
    public void navigateToMasterFragment_1_atStartup() {
        checkTitleDisplayed(R.string.master_fragment_1_title);
    }

    /**
     * Test navigate to the first Master fragment.
     */
    @Test
    public void navigateToMasterFragment_1() {
        navigateToAtName(R.string.master_fragment_1_title);
        checkTitleDisplayed(R.string.master_fragment_1_title);
    }

    /**
     * Test navigate to the second Master fragment.
     */
    @Test
    public void navigateToMasterFragment_2() {
        navigateToAtName(R.string.master_fragment_2_title);
        checkTitleDisplayed(R.string.master_fragment_2_title);
    }

    /**
     * Test navigate to the detail fragment by clicking the detail button, and navigate up.
     */
    @Test
    public void navigateToDetailFragment_1_1() {
        navigateToAtName(R.string.master_fragment_1_title);
        checkTitleDisplayed(R.string.master_fragment_1_title);

        onView(withId(R.id.button_detail)).perform(click());
        checkTitleDisplayed(R.string.detail_fragment_1_1_title);

        navigateUp(mMainActivityTestRule.getActivity().getActionBarToolbar());
        checkTitleDisplayed(R.string.master_fragment_1_title);
    }
}
