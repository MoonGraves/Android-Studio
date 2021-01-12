package com.example.java1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView theTxt;
    Button btn_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
               theTxt.setText("tanttax".toUpperCase());
           }
       });

    }

}
