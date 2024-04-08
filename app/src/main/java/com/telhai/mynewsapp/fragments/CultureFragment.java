package com.telhai.mynewsapp.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.loader.content.Loader;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.loader.content.Loader;
import android.util.Log;
import com.telhai.mynewsapp.model.News;
import com.telhai.mynewsapp.model.NewsLoader;
import com.telhai.mynewsapp.NewsPreferences;
import com.telhai.mynewsapp.R;

import java.util.List;


/**
 * The CultureFragment is a {@link BaseArticlesFragment} subclass that
 * reuses methods of the parent class by passing the specific type of article to be fetched.
 */
public class CultureFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = CultureFragment.class.getName();

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String cultureUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.culture));
        Log.e(LOG_TAG, cultureUrl);

        // Create a new loader for the given URL
        return new NewsLoader(getActivity(), cultureUrl);
    }
}
