package com.example.bernhard.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    // Wir definieren hier die verwendeten Views und Variablen
    private Button btn_click;
    private ProgressBar progressBar;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView gibt uns an, welches XML-Layout geladen wird
        setContentView(R.layout.activity_main);

        // findViewById verknüpft ein View-Element mit einer Variable
        btn_click = (Button)findViewById(R.id.button);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);


        // mithilfe der folgenden Methoden "konfigurieren" wir unsere ProgressBar
        progressBar.setProgress(count);
        progressBar.setMax(10);

        // setOnClickListener fügt uns zu unserem Button einen ClickListener hinzu
        // dafür müssen wir das Interface View.OnClickListener implementieren ( siehe Klassendefinition)
        // Der OnClickListener benötigt eine Implementierung der OnClick()-Methode ( weiter unten)
        // die Variable this beschreibt den context, in dem dieser OnClickListener definiert wird
        btn_click.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        // wurde die OnClick-Methode aufgerufen, durch Klicken des Buttons btn_click
        if( v == btn_click){
            // Überprüfung ob die ProgressBar voll ist
            if(count< 10){
                //Erhöhung der Variable Count und update der Progressbar

                progressBar.setProgress(count);
                count ++;
            }
            // Progressbar ist voll
            else{

                // Wenn die ProgressBar voll ist, soll auf eine andere Activity gewechelt werden:
                    // startActivity benötigt dazu einen Intent: http://developer.android.com/training/basics/firstapp/starting-activity.html
                   // ACHTUNG: Success.class muss in Android.xml definiert sein!
                startActivity(new Intent(this, Success.class));

                // setzen count und ProgressBar wieder null, für erneutes füllen
                count = 1;
                progressBar.setProgress(0);
            }
        }
    }
}
