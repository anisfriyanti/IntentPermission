package com.example.magbas00044.trainingtes;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CameraActivity extends AppCompatActivity {

    @BindView(R.id.btncapture)
    Button btncapture;
    @BindView(R.id.btnshow)
    Button btnshow;
    @BindView(R.id.showimage)
    ImageView showimage;
    Uri lokasifile;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btncapture, R.id.btnshow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btncapture:
//                String folderKamera="fotosaya" ;
//                File file =new File(Environment.getExternalStorageDirectory(), folderKamera);
//                if(!file.exists()){
//                    file.mkdir();
//                }
//                File file2= new File (Environment.getExternalStorageDirectory()
//                .getAbsolutePath() + "/"+ folderKamera + "/PIC " +)
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);

                    }
                Intent takePictureIntent= new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
                break;
            case R.id.btnshow:
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode== RESULT_OK) {
           Bundle extras =data.getExtras();
            Bitmap imageBitmap= (Bitmap)extras.get("data");

           showimage.setImageBitmap(imageBitmap);
        }
    }


    
}
