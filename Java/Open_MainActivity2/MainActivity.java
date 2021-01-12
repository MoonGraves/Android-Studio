package com.example.java1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button2;

    TextView theTxt;
    Button btn_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*
        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText("This is fun");
        */

       theTxt = (TextView) findViewById(R.id.textView2);
       btn_Button = (Button) findViewById(R.id.button1);

       //Change the button text
       Button button_btn = (Button)findViewById(R.id.button1);
       button_btn.setText("Click me");

       //set the text to uppercase & or .toLowerCase (if there is)
       btn_Button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v)
           {
               theTxt.setText("tanttax".toLowerCase());
           }
       });


       //Button to open another mainactivity2
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2(); //Need methods
            }
        });

    } //TODO:: Oncreate ENDS HERE

    //TODO:: methodi edellisen button2 kanssa
    public void openActivity2() {
        Intent intent = new Intent (this, Main2Activity.class);
        startActivity(intent);
    }

}
