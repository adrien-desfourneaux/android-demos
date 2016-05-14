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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.dieze.androiddemos.navigation.R;

/**
 * Abstract base class for Fragments.
 *
 * Created by adrien on 12/05/16.
 */
public abstract class BaseFragment extends Fragment {
    /**
     * The title to show in the ActionBar.
     */
    private CharSequence mTitle;

    /**
     * Called when the fragment's activity has been created and this fragment's view hierarchy
     * instantiated.
     *
     * We have to wait for the Activity to be created and available in order to apply the title.
     *
     * @param savedInstanceState The saved instance state.
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getTitle() == null) {
            setTitle(R.string.app_name);
        } else {
            applyTitle();
        }
    }

    /**
     * Set and save the ActionBar title for this Fragment, via a resource.
     *
     * @param titleResource The resource for the string title.
     */
    public void setTitle(int titleResource) {
        CharSequence titleChars = getResources().getString(titleResource);

        setTitle(titleChars);
    }

    /**
     * Set and save the ActionBar title for this Fragment, via a string.
     *
     * If the Activity is created and available, we apply the title to the Activity's ActionBar.
     *
     * @param title The string title.
     */
    public void setTitle(CharSequence title) {
        mTitle = title;

        if (getActivity() != null) {
            applyTitle();
        }
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    /**
     * Apply the Fragment's title to the Activity's ActionBar.
     *
     * At this point the Activity must be created and available.
     */
    protected void applyTitle() {
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        assert actionBar != null;

        actionBar.setTitle(getTitle());
    }
}
