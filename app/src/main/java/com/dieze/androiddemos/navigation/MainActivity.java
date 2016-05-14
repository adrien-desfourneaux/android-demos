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

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dieze.androiddemos.navigation.fragments.MasterFragment_1;
import com.dieze.androiddemos.navigation.fragments.MasterFragment_2;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {
    /**
     * Private ActionBar Toolbar instance.
     */
    private Toolbar mActionBarToolbar;

    /**
     * Private Navigation Drawer instance.
     */
    private Drawer mDrawer;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(savedInstanceState);
    }

    /**
     * Initialize the Activity.
     *
     * @param savedInstanceState The saved instance state.
     */
    protected void init(Bundle savedInstanceState) {
        initActionBar();
        initDrawer();

        if (savedInstanceState == null) {
            initNavigation();
        }
    }

    /**
     * Initialize the Activity ActionBar.
     *
     * We use a Toolbar as the ActionBar so that we can use the ActionBarDrawerToggle of the
     * MaterialDrawer library.
     */
    protected void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setActionBarToolbar(toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Initialize the Navigation Drawer using the MaterialDrawer library.
     */
    protected void initDrawer() {
        Drawer drawer = new DrawerBuilder()
                .withActivity(this)

                // Toolbar required to use MaterialDrawer's ActionBarDrawerToggle
                .withToolbar(getActionBarToolbar())

                // add items to the navigation drawer
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.master_fragment_1_title),
                        new PrimaryDrawerItem().withName(R.string.master_fragment_2_title)
                )

                // handle click on a navigation drawer item
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                        switch (position) {
                            case 0:
                                ft.replace(R.id.main_content, new MasterFragment_1());
                                break;

                            case 1:
                                ft.replace(R.id.main_content, new MasterFragment_2());
                                break;
                        }

                        ft.commit();
                        getDrawer().closeDrawer();

                        return true;
                    }
                })
                .build();

        setDrawer(drawer);
    }

    /**
     * Initialize the Navigation on the Activity.
     *
     * We are using Fragments to navigate the different pages on the Activity. This method shows the
     * first Fragment the user sees when entering the Activity.
     */
    protected void initNavigation() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_content, new MasterFragment_1());
        ft.commit();
    }

    public Toolbar getActionBarToolbar() {
        return mActionBarToolbar;
    }

    protected void setActionBarToolbar(Toolbar actionBarToolbar) {
        mActionBarToolbar = actionBarToolbar;
    }

    public Drawer getDrawer() {
        return mDrawer;
    }

    protected void setDrawer(Drawer drawer) {
        mDrawer = drawer;
    }
}
