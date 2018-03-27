package com.example.tramalho.deeplink;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        if(getIntent() != null && !Session.isIsFirst()) {

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Necessário Navegar em " + FirstActivity.class.getSimpleName())
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getIntent().setClass(SecondActivity.this, FirstActivity.class);
                            getIntent().setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(getIntent());
                            finish();
                        }
                    })
                    .create();

            alertDialog.show();
        }
    }
}
