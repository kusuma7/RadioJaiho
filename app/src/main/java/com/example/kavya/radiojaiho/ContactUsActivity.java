package com.example.kavya.radiojaiho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by KUSUMA on 1/11/2017.
 */

public class ContactUsActivity extends AppCompatActivity {

    EditText et1Name, et1EmailTo, et1Subject, et1Description;
    Button b1Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        b1Send = (Button)findViewById(R.id.button1_send);
        b1Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et1Name = (EditText)findViewById(R.id.editText1_name);
                String name1 = et1Name.getText().toString();
                et1EmailTo = (EditText)findViewById(R.id.editText1_to_emaiaddress);
                String to1 = et1EmailTo.getText().toString();
                et1Subject = (EditText)findViewById(R.id.editText1_subject_songRequest);
                String subject1 = et1Subject.getText().toString();
                et1Description = (EditText)findViewById(R.id.editText1_description);
                String description1 = et1Description.getText().toString();

                Intent email_contact_us = new Intent(Intent.ACTION_SEND);
                email_contact_us.putExtra(Intent.EXTRA_EMAIL, new String[]{ to1});
                email_contact_us.putExtra(Intent.EXTRA_SUBJECT, subject1);
                email_contact_us.putExtra(Intent.EXTRA_TEXT, "Name: " +name1 +'\n' +'\n' +description1 );
                email_contact_us.setType("message/rfc822");
                startActivity(Intent.createChooser(email_contact_us, "Choose an Email client :"));
            }
        });
    }

    @Override
    public void onBackPressed(){

        finish();
    }
}
