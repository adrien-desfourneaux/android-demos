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

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;

import com.dieze.androiddemos.navigation.R;
import com.mikepenz.materialdrawer.Drawer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static com.dieze.androiddemos.navigation.utils.DrawerUtils.getItemViewIdAtPosition;
import static org.hamcrest.Matchers.allOf;

/**
 * Useful methods to manipulate the Navigation Drawer in tests.
 */
public class DrawerUtils {

    /**
     * The resource id of the drawer layout.
     */
    public static final int LAYOUT_ID = R.id.material_drawer_layout;

    /**
     * The resource id of the drawer content.
     *
     * Using MaterialDrawer, this is a RecyclerView.
     */
    public static final int CONTENT_ID = R.id.material_drawer_recycler_view;

    /**
     * Open the navigation drawer.
     *
     * We check that the navigation drawer is closed before opening. If you want to just navigate to
     * a drawer item, use the {@link #navigateTo(int) navigateToDrawerItem} method.
     */
    public static void open() {
        onView(withId(LAYOUT_ID))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(DrawerActions.open());;
    }

    /**
     * Close the navigation drawer.
     *
     * We check that the navigation drawer is opened before closing.
     */
    public static void close() {
        onView(withId(LAYOUT_ID))
                .check(matches(isOpen(Gravity.LEFT)))
                .perform(DrawerActions.close());
    }

    /**
     * Open the navigation drawer and navigate to a specific item at position.
     *
     * @param drawer The DrawerUtils instance.
     * @param position The position of the DrawerItem to navigate to.
     */
    public static void navigateToAtPosition(Drawer drawer, int position) {
        navigateTo(getItemViewIdAtPosition(drawer, position));
    }

    /**
     * Open the navigation drawer and navigate to a specific item by id.
     *
     * Do not call openDrawer() before this method or your test will fail. This is because openDrawer()
     * cannot be called multiple times without closing the drawer.
     *
     * @param itemViewId The view id of the DrawerItem to navigate to.
     */
    public static void navigateTo(int itemViewId) {
        open();

        onView(withId(itemViewId))
                .perform(click());
    }

    /**
     * Open the navigation drawer and navigate to a specific item by name resource id.
     *
     * @param nameResourceId The name resource id of the item to navigate to.
     */
    public static void navigateToAtName(int nameResourceId) {
        String name = InstrumentationRegistry.getTargetContext().getString(nameResourceId);

        navigateToAtName(name);
    }

    /**
     * Open the navigation drawer and navigate to a specific item by name.
     *
     * Do not call openDrawer() before this method or your test will fail. This is because openDrawer()
     * cannot be called multiple times without closing the drawer.
     *
     * @param name The name of the item to navigate to.
     */
    public static void navigateToAtName(String name) {
        open();

        onView(allOf(withText(name), isDescendantOfA(withId(CONTENT_ID))))
                .perform(click());
    }

    /**
     * Navigate up from a detail fragment to a master fragment.
     *
     * This clicks the "home-as-up" left arrow button in the Toolbar.
     */
    public static void navigateUp(Toolbar toolbar) {
        onView(withContentDescription(toolbar.getNavigationContentDescription().toString()))
                .perform(click());
    }
}
