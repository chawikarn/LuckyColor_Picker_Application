package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodListAdapter extends BaseAdapter {
    private Context context ;
    private int layout;
    private ArrayList<Cloth> clothList ;

    public FoodListAdapter(Context context, int layout, ArrayList<Cloth> clothList) {
        this.context = context;
        this.layout = layout;
        this.clothList = clothList;
    }

    @Override
    public int getCount() {
        return clothList.size();
    }

    @Override
    public Object getItem(int position) {
        return clothList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private  class  ViewHolder{
        ImageView imageView ;
        TextView txtName;

    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
    View row = view ;
    ViewHolder holder = new ViewHolder();

    if(row == null){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           row = inflater.inflate(layout,null);

           holder.txtName = (TextView) row.findViewById(R.id.textcloth);
           holder.imageView = (ImageView)row.findViewById(R.id.imgcloth);
           row.setTag(holder);
    }
    else {
        holder =  (ViewHolder) row.getTag();
    }
Cloth cloth = clothList.get(position);
    holder.txtName.setText(cloth.getName());

    byte[] clothimage = cloth.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(clothimage,0,clothimage.length);
        holder.imageView.setImageBitmap(bitmap)  ;
        return row;
    }
}
