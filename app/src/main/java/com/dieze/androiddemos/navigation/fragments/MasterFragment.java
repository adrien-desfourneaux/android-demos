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

package com.dieze.androiddemos.navigation.fragments;

import android.support.v7.app.ActionBar;

import com.dieze.androiddemos.navigation.MainActivity;
import com.mikepenz.materialdrawer.Drawer;

/**
 * Abstract base class for a Master fragment.
 *
 * Created by adrien on 12/05/16.
 */
public abstract class MasterFragment extends BaseFragment {
    /**
     * {@inheritDoc}
     */
    @Override
    public void onResume() {
        super.onResume();
        setUpActionBarDrawerToggle();
    }

    /**
     * Set up the ActionBarDrawerToggle button icon and click behavior.
     *
     * On a MasterFragment the ActionBarDrawerToggle icon is the hamburger icon, and a click on the
     * ActionBarDrawerToggle triggers the default behavior of MaterialDrawer which is opening the
     * navigation drawer.
     */
    protected void setUpActionBarDrawerToggle() {
        MainActivity activity = (MainActivity)getActivity();
        Drawer drawer = activity.getDrawer();

        ActionBar actionBar = activity.getSupportActionBar();
        assert actionBar != null;

        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        drawer.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }
}
