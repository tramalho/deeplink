package com.example.tramalho.deeplink;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null && getIntent().getExtras() != null) {

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Navegar para activity B")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Class clazz = (Class) getIntent().getExtras().get("deepLink");
                            startActivity(new Intent(MainActivity.this, clazz));
                            finish();
                        }
                    })
                    .create();

            alertDialog.show();
        }
    }
}
