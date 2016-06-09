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

import com.mikepenz.materialdrawer.Drawer;

/**
 * Useful methods to manipulate the Navigation Drawer.
 */
public class DrawerUtils {

    /**
     * Get the view id for a DrawerItem at a position.
     *
     * Using MaterialDrawer 5.3.0, the view id of a DrawerUtils item is its the value of its hashCode().
     *
     * @see <a href="https://github.com/mikepenz/MaterialDrawer/blob/v5.3.0/library/src/main/java/com/mikepenz/materialdrawer/model/BasePrimaryDrawerItem.java#L60">The Source</a>
     *
     * @param drawer The DrawerUtils.
     * @param position The DrawerItem position.
     * @return The integer view id of the matching DrawerItem.
     */
    public static int getItemViewIdAtPosition(Drawer drawer, int position) {
        return drawer.getDrawerItems().get(position).hashCode();
    }
}
