package com.example.utkay.miacam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;


public class Cam1 extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    Bitmap bitmap = null;
    Camera.PictureCallback mPicture = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {

            if (data != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

                if (bitmap != null) {
                    Intent intent = new Intent(Cam1.this, Cam1Next.class);
                    intent.putExtra("photo1", bitmap);
                    startActivity(intent);
                }
            }
            camera.stopPreview();
        }
    };
    private Camera mCamera = null;
    private CameraView mCameraView = null;

    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam1);
        try{
            mCamera = Camera.open();//you can use open(int) to use different cameras
        } catch (Exception e){
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

        if(mCamera != null) {
            mCameraView = new CameraView(this, mCamera);//create a SurfaceView to show camera data
            FrameLayout camera_view = (FrameLayout)findViewById(R.id.camera_view);
            camera_view.addView(mCameraView);//add the SurfaceView to the layout
        }

        final ImageButton imgCapture = (ImageButton)findViewById(R.id.imgCapture);
        ImageButton focus = (ImageButton)findViewById(R.id.imgCircle);

        focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCamera.autoFocus(null);
            }
        });

        imgCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(" cam1");

                mCamera.startPreview();
                mCamera.takePicture(null, null, mPicture);
            }
        });

    }
}


