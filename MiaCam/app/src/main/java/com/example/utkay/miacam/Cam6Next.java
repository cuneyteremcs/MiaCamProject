package com.example.utkay.miacam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cam6Next extends AppCompatActivity {

    ImageButton Btnyes1;
    ImageButton Btnno1;
    ImageView photo;
    Bitmap bitmap;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam1_next);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final String subeAdi = sharedPref.getString("sube", "Not Available");
        final String kullaniciAdi = sharedPref.getString("kullanıcı", "Not Available");

        Intent intent = getIntent();
        final Bitmap bitmap = (Bitmap)intent.getParcelableExtra("photo6");

        Btnyes1 = (ImageButton) findViewById(R.id.yes1);
        Btnno1 = (ImageButton) findViewById(R.id.no1);
        photo = (ImageView) findViewById(R.id.photo);

        photo.setRotation(90);
        photo.setImageBitmap(bitmap);

        Btnyes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bitmap!=null){

                    Intent intent = getIntent();
                    file = (File)intent.getParcelableExtra("file1");

                    file = new File(Environment.getExternalStorageDirectory()+"/dirr/" + kullaniciAdi,"Tutanak.jpg");

                    try
                    {
                        FileOutputStream fileOutputStream=new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG,100, fileOutputStream);

                        fileOutputStream.flush();
                        fileOutputStream.close();

                        Intent intent2 = new Intent(Cam6Next.this, photoPage.class);
                        intent2.putExtra("file1", file);
                        startActivity(intent2);
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    catch(Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    Intent i= new Intent(Cam6Next.this, photoPage.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        Btnno1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Cam6Next.this, Cam6.class);
                startActivity(i);
            }
        });
    }
}
