package com.example.bernhard.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Success extends Activity implements View.OnClickListener{
    //verwendete Views
   private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // verwendetes layout = success.xml
        setContentView(R.layout.success);


        btn_back = (Button)findViewById(R.id.button2);
        btn_back.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if(v == btn_back){
            // finish() zeigt, wenn eine Activity abgeschlossen ist
            finish();
        }
    }
}
