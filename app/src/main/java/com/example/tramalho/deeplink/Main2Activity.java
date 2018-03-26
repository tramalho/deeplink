package com.example.tramalho.deeplink;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        if(getIntent() != null && new Random().nextInt(4) % 2 != 0) {

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Navegar para activity A")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                            intent.putExtra("deepLink", Main2Activity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .create();

            alertDialog.show();
        }
    }
}
