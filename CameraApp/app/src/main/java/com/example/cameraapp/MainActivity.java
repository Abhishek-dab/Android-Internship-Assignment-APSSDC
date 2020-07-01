package com.example.cameraapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button b_gallery;
    Button b1;
    Bitmap bitmap;
    public static final int CAMERA_REQUEST = 9999;
    public static final int GALLERY_REQUEST = 33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        b1 = findViewById(R.id.camera);
        b_gallery = findViewById(R.id.gallery_button);
        b1.setOnClickListener(this);
        b_gallery.setOnClickListener(this);
    }

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.camera:
                        openCamera();
                        break;
                    case R.id.gallery_button:
                        openGallery();
                        break;
                }



    }

    private void openGallery() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i,GALLERY_REQUEST);
    }
    private void openCamera() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST){
            if(resultCode==RESULT_OK){
                bitmap = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }
        }
        if(requestCode==GALLERY_REQUEST){
            if(resultCode==RESULT_OK){
                Uri u = data.getData();
                imageView.setImageURI(u);
            }
        }


    }

}