package com.example.tramalho.deeplink;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null && getIntent().getData() != null) {

            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Navegando para proxima activity")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Session.setIsFirst(true);

                            Class targetClass = extractTargetClass(getIntent());

                            Intent intent = new Intent(FirstActivity.this, targetClass);
                            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                            startActivity(intent);

                            finish();
                        }
                    })
                    .create();

            alertDialog.show();
        }
    }

    private Class extractTargetClass(Intent intent) {

        Class clazz = FirstActivity.class;

        String lastPathSegment = intent.getData().getLastPathSegment();

        if (getString(R.string.second_path_prefix).contains(lastPathSegment)) {
            clazz = SecondActivity.class;
        }
        return clazz;
    }
}
