package com.telhai.mynewsapp.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import 	android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.telhai.mynewsapp.R;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);


        // Extract the url that we sent from the NewsAdapter.java
        Uri uri = getIntent().getExtras().getParcelable("web_uri_identifier");


        // Navigate with the app icon in the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        webSettings.setJavaScriptEnabled(true);

        myWebView.loadUrl(uri.toString());

        System.out.println("url"+ uri.toString());
    }


    // Go back to the MainActivity when up button in action bar is clicked on.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context. */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page. */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }

}
