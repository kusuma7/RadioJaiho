package com.example.kavya.radiojaiho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by KUSUMA on 1/10/2017.
 */

public class RequestSongActivity extends AppCompatActivity {


    EditText etEmailTo, etSubject, etDescription;
    Button bSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_song);

        bSend = (Button)findViewById(R.id.button_send);
        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etEmailTo = (EditText)findViewById(R.id.editText_to_emaiaddress);
                String to = etEmailTo.getText().toString();
                etSubject = (EditText)findViewById(R.id.editText_subject_songRequest);
                String subject = etSubject.getText().toString();
                etDescription = (EditText)findViewById(R.id.editText_description);
                String description = etDescription.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, description);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(RequestSongActivity.this, MainActivity.class);
        startActivity(intent);
    }
}