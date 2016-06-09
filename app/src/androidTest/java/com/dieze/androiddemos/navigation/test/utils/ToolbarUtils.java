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

import com.dieze.androiddemos.navigation.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Useful methods to manipulate the Toolbar in tests.
 */
public class ToolbarUtils {

    /**
     * The resource id of the Toolbar.
     */
    public final static int TOOLBAR_ID = R.id.toolbar;

    /**
     * Check a toolbar title is displayed via a string resource id.
     *
     * @param resourceId The string resource id of the toolbar title to check.
     */
    public static void checkTitleDisplayed(int resourceId) {
        onView(allOf(withText(resourceId), withParent(withId(TOOLBAR_ID))))
                .check(matches(isDisplayed()));
    }

    /**
     * Check a toolbar title is displayed via a String title.
     *
     * @param title The String title to check.
     */
    public static void checkTitleDisplayed(String title) {
        onView(allOf(withText(title), withParent(withId(TOOLBAR_ID))))
                .check(matches(isDisplayed()));
    }
}
