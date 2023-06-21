package com.example.facebooklogin;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UploadImage extends AppCompatActivity {
    private Button btn;
    ImageView iv;
    int myrequestcode=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        btn=findViewById(R.id.camera_button);
        iv=findViewById(R.id.image_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera,myrequestcode);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent mydata) {
        super.onActivityResult(requestCode, resultCode, mydata);

        if(requestCode==0)
        {
            Bitmap bit= (Bitmap) mydata.getExtras().get("data");
            iv.setImageBitmap(bit);
        }
    }
}


