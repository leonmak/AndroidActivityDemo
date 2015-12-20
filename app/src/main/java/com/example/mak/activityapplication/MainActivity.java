package com.example.mak.activityapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button toSecond;
    static final int REQUEST_CODE =1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // bundle class holds all object instance states
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSecond = (Button)findViewById(R.id.toSecond);
        toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, Main2Activity.class);
                intent.putExtra("key", "Some value");

                startActivityForResult(intent, REQUEST_CODE);

//                startActivity(intent);

//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra("key_from_second");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
