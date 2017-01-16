package com.example.kavya.radiojaiho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by KUSUMA on 1/9/2017.
 */

public class ShoutBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shout_box);

        WebView webView = (WebView)findViewById(R.id.webview_shout_box);
        webView.loadUrl("http://www.radiojaiho.com/ajax-chat.html");
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(ShoutBoxActivity.this, MainActivity.class);
        startActivity(intent);
    }
}