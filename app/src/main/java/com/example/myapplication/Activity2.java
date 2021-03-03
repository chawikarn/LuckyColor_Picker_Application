package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity2 extends AppCompatActivity {
Spinner spinner ;
Button btnList,btnAdd,btnChoose,btnCamera;
ImageView imageView ;
    final int REQUEST_CODE_GALLERY = 999;
    private static final int CAMERA_REQUEST = 100;
    public static String a ;
    public static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ini() ;

        sqLiteHelper = new SQLiteHelper(this,"Wardb.sqlite",null,1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS War(Id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,image BLOG)");


        btnChoose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ActivityCompat.requestPermissions(
                Activity2.this,
               new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
               REQUEST_CODE_GALLERY
               );
        }
       });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                a = (String) spinner.getSelectedItem();

                try {

                    sqLiteHelper.insertData(

                            a,imageViewToByte(imageView)

                    );
                    Toast.makeText(getApplicationContext(),"Added successfully!",Toast.LENGTH_SHORT).show();
                     imageView.setImageResource(R.mipmap.ic_launcher);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        }) ;

       btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, CAMERA_REQUEST);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item0:
                Intent intent = new Intent(this, ClothList.class);
                startActivity(intent);
                return true;
            case R.id.home:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return true;


    }
            return super.onOptionsItemSelected(item);
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return  byteArray;

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){

            if(grantResults.length >0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent (Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);


            }
            else  {
                Toast.makeText(getApplicationContext(),"You dont have Permission to Access !",Toast.LENGTH_SHORT).show();

            }
            return ;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

       if (requestCode == REQUEST_CODE_GALLERY  && data !=null){

        Uri uri = data.getData() ;
           try {
               InputStream inputStream = getContentResolver().openInputStream(uri);

               Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
               imageView.setImageBitmap(bitmap);
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }


       }else if (requestCode == CAMERA_REQUEST  && data !=null){




               Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);



        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void ini(){

        spinner = (Spinner)findViewById(R.id.wardrobe_array);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnCamera = (Button)findViewById(R.id.btnCamera);
        btnChoose = (Button)findViewById(R.id.btnChoose);
        imageView = (ImageView)findViewById(R.id.Picture);


    }
}
