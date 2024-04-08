package com.telhai.mynewsapp.fragments;

import com.telhai.mynewsapp.model.News;
import com.telhai.mynewsapp.DataService.NewsLoader;
import com.telhai.mynewsapp.NewsPreferences;
import com.telhai.mynewsapp.R;
import androidx.annotation.NonNull;
import androidx.loader.content.Loader;
import android.os.Bundle;

import android.util.Log;

import java.util.List;

public class SocietyFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = SocietyFragment.class.getName();

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String societyUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.society));
        Log.e(LOG_TAG, societyUrl);

        // Create a new loader for the given URL
        return new NewsLoader(getActivity(), societyUrl);
    }
}
