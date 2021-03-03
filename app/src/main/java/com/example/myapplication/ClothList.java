package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ClothList extends AppCompatActivity {
    ImageView imageView ;
    GridView gridView;
    ArrayList<Cloth> list;
    FoodListAdapter adapter = null;
    Spinner sp ;
    String a ,text;
    public static SQLiteHelper sqLiteHelper;
    String cardStatusString ;
TextView t ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cloth_list);
        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new FoodListAdapter(this, R.layout.cloth_item, list);
        gridView.setAdapter(adapter);
        imageView = (ImageView)findViewById(R.id.idc);
        sqLiteHelper = new SQLiteHelper(this,"Wardb.sqlite",null,1);


        //Cursor cursor = Activity2.sqLiteHelper.getData("SELECT * FROM War WHERE name=\""+ text +"\"");
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM War ");
        list.clear();
        while (cursor.moveToNext()) {


            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            byte[] image = cursor.getBlob(2);
            list.add(new Cloth(id, name, image));
        }
        adapter.notifyDataSetChanged();


        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                CharSequence[] items = {"Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(ClothList.this);
                dialog.setTitle("Choose an action ");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {

                        if (item == 0) {
                            // update
                            Cursor c = sqLiteHelper.getData("SELECT Id FROM War ");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()) {
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));

                        } /*else {
                            // update
                            //Toast.makeText(getApplicationContext(), "Delete..", Toast.LENGTH_SHORT).show();
                            Cursor c = Activity2.sqLiteHelper.getData("SELECT Id FROM War ");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()) {
                                arrID.add(c.getInt(0));
                            }
                            showDialogUpdate(ClothList.this, arrID.get(position));
                            //  Toast.makeText(getApplicationContext(), "Update..", Toast.LENGTH_SHORT).show();
                        }*/

                    }
                });


                //show dialog

                dialog.show();
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.Add:
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);

                return true;


            case R.id.item0:
                imageView.setBackgroundResource(R.drawable.ic_clothes_hanger);
                Toast.makeText(this,"All",Toast.LENGTH_SHORT).show();
                text = "Tops";
                Cursor cursor = sqLiteHelper.getData("SELECT * FROM War");
                list.clear();
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    byte[] image = cursor.getBlob(2);
                    list.add(new Cloth(id, name, image));
                }
                adapter.notifyDataSetChanged();
                return true;



            case R.id.item1:
                imageView.setBackgroundResource(R.drawable.ic_tshirt);
                Toast.makeText(this,"Tops",Toast.LENGTH_SHORT).show();
                text = "Tops";
                cursor = sqLiteHelper.getData("SELECT * FROM War WHERE name=\""+ text +"\"");
                list.clear();
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    byte[] image = cursor.getBlob(2);
                    list.add(new Cloth(id, name, image));
                }
                adapter.notifyDataSetChanged();
                return true;


            case R.id.item2:
                imageView.setBackgroundResource(R.drawable.ic_women_pants);
                Toast.makeText(this,"Trousers",Toast.LENGTH_SHORT).show();
                text = "Trousers";
                cursor = sqLiteHelper.getData("SELECT * FROM War WHERE name=\""+ text +"\"");
                list.clear();
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    byte[] image = cursor.getBlob(2);
                    list.add(new Cloth(id, name, image));
                }
                adapter.notifyDataSetChanged();
                return true;


            case R.id.item3:
                imageView.setBackgroundResource(R.drawable.ic_skirt);
                Toast.makeText(this,"Skirt",Toast.LENGTH_SHORT).show();
                text = "Skirt";
                cursor = sqLiteHelper.getData("SELECT * FROM War WHERE name=\""+ text +"\"");
                list.clear();
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    byte[] image = cursor.getBlob(2);
                    list.add(new Cloth(id, name, image));
                }
                adapter.notifyDataSetChanged();
                return true;


            case R.id.item4:
                imageView.setBackgroundResource(R.drawable.ic_clothes);
                Toast.makeText(this,"One Suit",Toast.LENGTH_SHORT).show();
                text = "One suit";
                cursor = sqLiteHelper.getData("SELECT * FROM War WHERE name=\""+ text +"\"");
                list.clear();
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    byte[] image = cursor.getBlob(2);
                    list.add(new Cloth(id, name, image));
                }
                adapter.notifyDataSetChanged();
                return true;


            case R.id.item5:
                imageView.setBackgroundResource(R.drawable.ic_sneakers);
                Toast.makeText(this,"Shoes",Toast.LENGTH_SHORT).show();
                text = "Shoes";
                cursor = sqLiteHelper.getData("SELECT * FROM War WHERE name=\""+ text +"\"");
                list.clear();
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    byte[] image = cursor.getBlob(2);
                    list.add(new Cloth(id, name, image));
                }
                adapter.notifyDataSetChanged();
                return true;


            case R.id.item6:
                imageView.setBackgroundResource(R.drawable.ic_wristwatch);
                Toast.makeText(this,"Accessories",Toast.LENGTH_SHORT).show();
                text = "Accessories";
                cursor = sqLiteHelper.getData("SELECT * FROM War WHERE name=\""+ text +"\"");
                list.clear();
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    byte[] image = cursor.getBlob(2);
                    list.add(new Cloth(id, name, image));
                }
                adapter.notifyDataSetChanged();
                return true;

            case R.id.item7:
                imageView.setBackgroundResource(R.drawable.ic_options);
                Toast.makeText(this,"others",Toast.LENGTH_SHORT).show();
                text = "others";
                cursor = sqLiteHelper.getData("SELECT * FROM War WHERE name=\""+ text +"\"");
                list.clear();
                while (cursor.moveToNext()) {

                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    byte[] image = cursor.getBlob(2);
                    list.add(new Cloth(id, name, image));
                }
                adapter.notifyDataSetChanged();
                return true;


            default: return super.onOptionsItemSelected(item);
        }

    }

    ImageView imageViewCloth;




    private  void showDialogUpdate (Activity activity,final int position  ){

        final  Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.cloth_list);
        dialog.setTitle("Update");

        imageViewCloth  = (ImageView) dialog.findViewById(R.id.imageViewCloth) ;
        final Spinner edtName = (Spinner) dialog.findViewById(R.id.edtName);
        Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);

        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        //set height for dialog
        int height = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.7);
        dialog.getWindow().setLayout(width,height);
        dialog.show();

        imageViewCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //request photo library
                ActivityCompat.requestPermissions(
                        ClothList.this,
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        888

                );


            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    a = (String) edtName.getSelectedItem();
                    Activity2.sqLiteHelper.updateData(
                            position,a,
                            Activity2.imageViewToByte(imageViewCloth)

                    ) ;
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Update Successful ",Toast.LENGTH_SHORT).show();
                }
                catch (Exception error) {

                    Log.e("Update error" , error.getMessage());
                }
                updateClothList();


            }
        });
    }

    private  void  showDialogDelete (final int id){

        final   AlertDialog.Builder dialogDelete = new AlertDialog.Builder(ClothList.this);
        dialogDelete.setTitle("Warnning !!");
        dialogDelete.setMessage("Do you want to delete ? " );
        dialogDelete.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                   sqLiteHelper.deleteData(id);
                    Toast.makeText(getApplicationContext(), "delete Successful ", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
                updateClothList();
            }

        });
        dialogDelete.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }





    private void  updateClothList () {

        Cursor cursor = sqLiteHelper.getData("SELECT * FROM War");
        list.clear();
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            byte[] image = cursor.getBlob(2);
            list.add(new Cloth(id, name, image));
        }
        adapter.notifyDataSetChanged();

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){

            if(grantResults.length >0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent (Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,888);


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

        if (requestCode == 888  && data !=null){

            Uri uri = data.getData() ;
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewCloth.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}



