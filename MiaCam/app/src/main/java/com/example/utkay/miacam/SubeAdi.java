package com.example.utkay.miacam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.Serializable;

public class SubeAdi extends AppCompatActivity {

    EditText etSubeAdı, etKullanıcıAdı;
    SharedPreferences sharedPref, sharedPref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sube_adi);

        etSubeAdı = (EditText) findViewById(R.id.editText);
        etKullanıcıAdı = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button2);
        Button cik = (Button) findViewById(R.id.button6);

        // Create object of SharedPreferences.
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //now get Editor
                SharedPreferences.Editor editor = sharedPref.edit();
                SharedPreferences.Editor editor2 = sharedPref2.edit();
                //put your value
                editor.putString("sube", etSubeAdı.getText().toString());
                editor2.putString("kullanıcı", etKullanıcıAdı.getText().toString());
                //commits your edits
                editor.commit();
                editor2.commit();

                Intent i= new Intent(SubeAdi.this, Cam1.class);
                startActivity(i);
            }
        });

        cik.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
