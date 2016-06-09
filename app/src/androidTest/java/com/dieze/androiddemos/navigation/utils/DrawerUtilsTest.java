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

package com.dieze.androiddemos.navigation.utils;

import android.support.test.rule.ActivityTestRule;

import com.dieze.androiddemos.navigation.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static com.dieze.androiddemos.navigation.utils.DrawerUtils.getItemViewIdAtPosition;
import static junit.framework.Assert.assertNotNull;

/**
 * Tests for the DrawerUtils.
 */
public class DrawerUtilsTest {

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
     * Test #getItemViewIdAtPosition.
     *
     * The MainActivity must have at least one item for this test to succeed.
     */
    @Test
    public void testGetItemViewIdAtPosition() {
        assertNotNull(getItemViewIdAtPosition(mMainActivityTestRule.getActivity().getDrawer(), 0));
    }
}
