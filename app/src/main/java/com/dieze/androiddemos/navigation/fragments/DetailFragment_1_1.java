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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dieze.androiddemos.navigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment_1_1 extends DetailFragment {
    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setTitle(R.string.detail_fragment_1_1_title);
        return inflater.inflate(R.layout.fragment_detail_1_1, container, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpEventListeners();
    }

    /**
     * Set up the Event Listeners for the current View.
     */
    protected void setUpEventListeners() {
        View view = getView();
        assert view != null;

        /**
         * Button to the first child DetailFragment.
         */
        view.findViewById(R.id.button_detail_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, new DetailFragment_1_1_1())
                        .addToBackStack("detail_1_1_1")
                        .commit();
            }
        });

        /**
         * Button to the second child DetailFragment.
         */
        view.findViewById(R.id.button_detail_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, new DetailFragment_1_1_2())
                        .addToBackStack("detail_1_1_2")
                        .commit();
            }
        });
    }
}
