package com.example.utkay.miacam;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class photoPage extends AppCompatActivity {

    final static private String APP_KEY = "o7fnn8ui6kth6g9";
    final static private String APP_SECRET = "mmt5oke4dlowrm6";
    AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);

    AndroidAuthSession session = new AndroidAuthSession(appKeys);

    FileInputStream inputStream;
    FileInputStream inputStream2;
    FileInputStream inputStream3;
    FileInputStream inputStream4;
    FileInputStream inputStream5;
    FileInputStream inputStream6;
    DropboxAPI.Entry response;
    DropboxAPI.Entry response2;
    DropboxAPI.Entry response3;
    DropboxAPI.Entry response4;
    DropboxAPI.Entry response5;
    DropboxAPI.Entry response6;

    DropboxAPI<AndroidAuthSession> mDBApi;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    public photoPage() {
        mDBApi = new DropboxAPI<AndroidAuthSession>(session);
        // When user returns to your activity, after authentication:
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_page);

        mDBApi.getSession().startOAuth2Authentication(photoPage.this);

        TextView textview = (TextView) findViewById(R.id.textView);
        TextView textview2 = (TextView) findViewById(R.id.textView2);
        final Button gonder = (Button) findViewById(R.id.button3);
        Button anaMenu = (Button) findViewById(R.id.button4);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final String subeAdi = sharedPref.getString("sube", "Not Available");

        final SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);
        final String kullaniciAdi = sharedPref2.getString("kullanıcı", "Not Available");

        textview.setText("" + subeAdi);
        textview2.setText("" + kullaniciAdi);

        ImageView view1 = (ImageView) findViewById(R.id.imageView);
        File imgFile = new File(Environment.getExternalStorageDirectory() + "/dirr/" + kullaniciAdi +"/" + "KurulumdanOnce.jpg");
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        view1.setRotation(90);
        view1.setImageBitmap(myBitmap);

        ImageView view2 = (ImageView) findViewById(R.id.imageView2);
        File imgFile2 = new File(Environment.getExternalStorageDirectory() + "/dirr/" + kullaniciAdi + "/" + "Topuz.jpg");
        Bitmap myBitmap2 = BitmapFactory.decodeFile(imgFile2.getAbsolutePath());
        view2.setRotation(90);
        view2.setImageBitmap(myBitmap2);

        ImageView view3 = (ImageView) findViewById(R.id.imageView3);
        File imgFile3 = new File(Environment.getExternalStorageDirectory() + "/dirr/" + kullaniciAdi + "/" + "Cihaz.jpg");
        Bitmap myBitmap3 = BitmapFactory.decodeFile(imgFile3.getAbsolutePath());
        view3.setRotation(90);
        view3.setImageBitmap(myBitmap3);

        ImageView view4 = (ImageView) findViewById(R.id.imageView4);
        File imgFile4 = new File(Environment.getExternalStorageDirectory() + "/dirr/" + kullaniciAdi + "/" + "Kilit.jpg");
        Bitmap myBitmap4 = BitmapFactory.decodeFile(imgFile4.getAbsolutePath());
        view4.setRotation(90);
        view4.setImageBitmap(myBitmap4);

        ImageView view5 = (ImageView) findViewById(R.id.imageView5);
        File imgFile5 = new File(Environment.getExternalStorageDirectory() + "/dirr/" + kullaniciAdi + "/" + "Buton.jpg");
        Bitmap myBitmap5 = BitmapFactory.decodeFile(imgFile5.getAbsolutePath());
        view5.setRotation(90);
        view5.setImageBitmap(myBitmap5);

        ImageView view6 = (ImageView) findViewById(R.id.imageView6);
        File imgFile6 = new File(Environment.getExternalStorageDirectory() + "/dirr/" + kullaniciAdi + "/" + "Tutanak.jpg");
        Bitmap myBitmap6 = BitmapFactory.decodeFile(imgFile6.getAbsolutePath());
        view6.setRotation(90);
        view6.setImageBitmap(myBitmap6);


        gonder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                view.setEnabled(false);



                final File file = new File(Environment.getExternalStorageDirectory()
                        + "/dirr/" + kullaniciAdi + "/" + "KurulumdanOnce.jpg");
                inputStream = null;
                try {
                    inputStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                final File file2 = new File(Environment.getExternalStorageDirectory()
                        + "/dirr/" + kullaniciAdi + "/" + "Topuz.jpg");
                inputStream2 = null;
                try {
                    inputStream2 = new FileInputStream(file2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                final File file3 = new File(Environment.getExternalStorageDirectory()
                        + "/dirr/" + kullaniciAdi + "/" + "Cihaz.jpg");
                inputStream3 = null;
                try {
                    inputStream3 = new FileInputStream(file3);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                final File file4 = new File(Environment.getExternalStorageDirectory()
                        + "/dirr/" + kullaniciAdi + "/" + "Kilit.jpg");
                inputStream4 = null;
                try {
                    inputStream4 = new FileInputStream(file4);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                final File file5 = new File(Environment.getExternalStorageDirectory()
                        + "/dirr/" + kullaniciAdi + "/" + "Buton.jpg");
                inputStream5 = null;
                try {
                    inputStream5 = new FileInputStream(file5);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                final File file6 = new File(Environment.getExternalStorageDirectory()
                        + "/dirr/" + kullaniciAdi + "/" + "Tutanak.jpg");
                inputStream6 = null;
                try {
                    inputStream6 = new FileInputStream(file6);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                response = null;

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response = mDBApi.putFile(subeAdi + "-"+ kullaniciAdi+"/"+"KurulumdanOnce.jpg", inputStream,
                                    file.length(), null, null);
                        } catch (DropboxException e) {
                            e.printStackTrace();
                        }
                        Log.i("DbExampleLog", "The uploaded file's rev is: " + response.rev);
                    }
                });

                response2 = null;

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response2 = mDBApi.putFile(subeAdi + "-"+ kullaniciAdi + "/" + "Topuz.jpg", inputStream2,
                                    file2.length(), null, null);
                        } catch (DropboxException e) {
                            e.printStackTrace();
                        }
                        Log.i("DbExampleLog", "The uploaded file's rev is: " + response2.rev);
                    }
                });

                response3 = null;

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response3 = mDBApi.putFile(subeAdi + "-"+ kullaniciAdi + "/" +"Cihaz.jpg", inputStream3,
                                    file3.length(), null, null);
                        } catch (DropboxException e) {
                            e.printStackTrace();
                        }
                        Log.i("DbExampleLog", "The uploaded file's rev is: " + response3.rev);
                    }
                });

                response4 = null;

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response4 = mDBApi.putFile(subeAdi + "-"+ kullaniciAdi + "/" + "Kilit.jpg", inputStream4,
                                    file4.length(), null, null);
                        } catch (DropboxException e) {
                            e.printStackTrace();
                        }
                        Log.i("DbExampleLog", "The uploaded file's rev is: " + response4.rev);
                    }
                });

                response5 = null;

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response5 = mDBApi.putFile(subeAdi + "-"+ kullaniciAdi + "/" + "Buton.jpg" , inputStream5,
                                    file5.length(), null, null);
                        } catch (DropboxException e) {
                            e.printStackTrace();
                        }
                        Log.i("DbExampleLog", "The uploaded file's rev is: " + response5.rev);
                    }
                });

                response6 = null;

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            response6 = mDBApi.putFile(subeAdi + "-"+ kullaniciAdi + "/" + "Tutanak.jpg", inputStream6,
                                    file6.length(), null, null);
                        } catch (DropboxException e) {
                            e.printStackTrace();
                        }
                        Log.i("DbExampleLog", "The uploaded file's rev is: " + response6.rev);
                    }
                });

                Toast.makeText(photoPage.this, "Fotoğraflar başarıyla gönderildi!", Toast.LENGTH_LONG).show();
            }
        });

        anaMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                gonder.setEnabled(true);

                finish();
                Intent i= new Intent(photoPage.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
/*
    public DropboxAPI.Entry createFolder(java.lang.String path) throws DropboxException {
        path = "hah";

        DropboxAPI.Entry existingEntry = mDBApi.metadata("/naber", 1, null, false, null);
        Log.i("DbExampleLog", "The file's rev is now: " + existingEntry.rev);

        return existingEntry;
    }
    */

    public void onExit(View view) {
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    protected void onResume() {
        super.onResume();

        if (mDBApi.getSession().authenticationSuccessful()) {
            try {
                // Required to complete auth, sets the access token on the session
                mDBApi.getSession().finishAuthentication();

                String accessToken = mDBApi.getSession().getOAuth2AccessToken();

            } catch (IllegalStateException e) {
                Log.i("DbAuthLog", "Error authenticating", e);
            }
        }
    }
}
