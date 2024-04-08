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

/**
 * The WorldFragment is a {@link BaseArticlesFragment} subclass that
 * reuses methods of the parent class by passing the specific type of article to be fetched.
 */
public class WorldFragment extends BaseArticlesFragment {

    private static final String LOG_TAG = WorldFragment.class.getName();

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        String worldUrl = NewsPreferences.getPreferredUrl(getContext(), getString(R.string.world));
        Log.e(LOG_TAG, worldUrl);

        // Create a new loader for the given URL


        return new NewsLoader(getActivity(), worldUrl);
    }
}
