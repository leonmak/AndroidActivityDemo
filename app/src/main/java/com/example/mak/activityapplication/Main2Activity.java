package com.example.mak.activityapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView myTextView;
    private Button goBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        myTextView = (TextView)findViewById(R.id.myTextView);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String myString = extras.getString("key"); // '.get' what was '.put'
            myTextView.setText(myString);
        }


        goBackBtn = (Button)findViewById(R.id.toFirst);

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent returnIntent = getIntent();
                returnIntent.putExtra("key_from_second", "I'm from second activity");
                returnIntent.putExtra("key1", "I'm also from second activity");

                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    } }

