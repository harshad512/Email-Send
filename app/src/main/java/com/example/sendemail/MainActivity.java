package com.example.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText to,subject,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to = (EditText)findViewById(R.id.to);
        subject = (EditText)findViewById(R.id.subject);
        message = (EditText)findViewById(R.id.message1);
        send = (Button)findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (to.getText().toString().isEmpty() || subject.getText().toString().isEmpty() || message.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Fill all field",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("mailto:" +to.getText().toString()));
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}