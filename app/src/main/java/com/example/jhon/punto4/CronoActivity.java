package com.example.jhon.punto4;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class CronoActivity extends AppCompatActivity implements View.OnClickListener {

    Chronometer cronomether;
    Button iniciar, detener, reiniciar, siguiente;
    Toolbar toolbar;
    long timeWhenStopped = 0;
    boolean isStop = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);

        iniciar= (Button) findViewById(R.id.iniciar);
        detener= (Button) findViewById(R.id.detener);
        reiniciar= (Button) findViewById(R.id.reiniciar);
        siguiente = (Button) findViewById(R.id.siguiente);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Crono");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        siguiente.setOnClickListener(this);
        iniciar.setOnClickListener(this);
        detener.setOnClickListener(this);
        reiniciar.setOnClickListener(this);

        cronomether= (Chronometer) findViewById(R.id.chronometer1);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            onBackPressed();
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iniciar:
                if (isStop) {
                    cronomether.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                    cronomether.start();
                    isStop = false;
                }


            break;
            case R.id.detener:
                if (!isStop) {
                    timeWhenStopped = cronomether.getBase() - SystemClock.elapsedRealtime();
                    cronomether.stop();
                    isStop = true;
                }
                break;
            case R.id.reiniciar:
                cronomether.setBase(SystemClock.elapsedRealtime());
                timeWhenStopped = 0;
                break;
            case R.id.siguiente:
                startActivity(new Intent(this,MainActivity.class));
                break;

        }
    }
}
