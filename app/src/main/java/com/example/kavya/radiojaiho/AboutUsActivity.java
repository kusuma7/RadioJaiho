package com.example.kavya.radiojaiho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by KUSUMA on 1/9/2017.
 */

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(AboutUsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
