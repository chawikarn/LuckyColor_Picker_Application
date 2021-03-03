package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class Activity1 extends AppCompatActivity {
    TextView textView, textView2, textView3, textView4,textname1,textname2;
    public String value1 = "";
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Drawable d = getResources().getDrawable(R.drawable.box);
        setContentView(R.layout.activity_1);
        Intent intent = getIntent();
        Color a;

        String value1 = intent.getStringExtra("key1");
        String value2 = intent.getStringExtra("key2");

        TextView topic;
        topic = (TextView) findViewById(R.id.Topic);
        textView = (TextView) findViewById(R.id.color);
        textView2 = (TextView) findViewById(R.id.color2);
        textView3 = (TextView) findViewById(R.id.Avoid);
        textView4 = (TextView) findViewById(R.id.Avoid2);
        textname1 = (TextView) findViewById(R.id.colorname1);
        textname2 = (TextView) findViewById(R.id.colorname2);
        imageView =  findViewById(R.id.No);

        topic.setText(value1);


        if (value1.contentEquals("Work")) {

            imageView.setBackgroundResource(R.drawable.ic_work);
            switch (value2) {
                case "1":
                    textView.setBackgroundResource(R.drawable.orange_brown);
                    textView2.setBackgroundResource(R.drawable.brown);
                    textView3.setBackgroundResource(R.drawable.box);
                    textname1.setText("Orange and Brown");
                    textname2.setText("Red!");
                    showToast("MONDAY");
                    break;
                case "2":
                    textView.setBackgroundResource(R.drawable.lightpurple);

                    textView3.setBackgroundResource(R.drawable.yellow);
                    textView3.setBackgroundResource(R.drawable.white);
                    textname1.setText("LightPurple");
                    textname2.setText("Yellow and White !");
                    showToast("TUESDAY");
                    break;
                case "3":
                    showToast("WEDNESDAY");
                    textView.setBackgroundResource(R.drawable.lighblue);
                    //textView2.setBackgroundResource(R.drawable.brown);
                    textView3.setBackgroundResource(R.drawable.pink);
                    textname1.setText("Darkblue");
                    textname2.setText("Pink!");

                    break;
                case "4":
                    showToast("THURSDAY");
                    textView.setBackgroundResource(R.drawable.yellow);
                    textView2.setBackgroundResource(R.drawable.grey);
                    textView3.setBackgroundResource(R.drawable.purple);
                    textView4.setBackgroundResource(R.drawable.black);
                    textname1.setText("Yellow and grey");
                    textname2.setText("Purple and Black !");
                    break;
                case "5":
                    showToast("FRIDAY");
                    textView.setBackgroundResource(R.drawable.green);
                   // textView2.setBackgroundResource(R.drawable.white);
                    textView3.setBackgroundResource(R.drawable.lightpurple);
                    textname1.setText("Green");
                    textname2.setText("lightpurple!");
                    break;
                case "6":
                    showToast("SATURDAY");
                    textView.setBackgroundResource(R.drawable.box);

                    textView3.setBackgroundResource(R.drawable.green);
                    textname1.setText("Red");
                    textname2.setText("Green !");
                    break;
                case "7":
                    textView.setBackgroundResource(R.drawable.purple);
                    textView2.setBackgroundResource(R.drawable.black);
                    textView3.setBackgroundResource(R.drawable.lighblue);
                    textView4.setBackgroundResource(R.drawable.blue);
                    textname1.setText("Purple and Black");
                    textname2.setText("DarkBlue and Blue !");
                    showToast("SUNDAY");
                    break;
                default:
                    showToast("---INVALID---");
                    break;
            }
        }
        else if (value1.contentEquals("Love")) {

            imageView.setBackgroundResource(R.drawable.ic_love);
            switch (value2) {
                case "1":
                    textView.setBackgroundResource(R.drawable.green);
                    //textView2.setBackgroundResource(R.drawable.brown);
                    textView3.setBackgroundResource(R.drawable.box);
                    textname1.setText("Green");
                    textname2.setText("Red !");
                    showToast("MONDAY");
                    break;
                case "2":
                    textView.setBackgroundResource(R.drawable.purple);
                    textView2.setBackgroundResource(R.drawable.black);
                    textView3.setBackgroundResource(R.drawable.box);
                    textname1.setText("Purple and Black");
                    textname2.setText("Red !");
                    showToast("TUESDAY");
                    break;
                case "3":
                    showToast("WEDNESDAY");
                    textView.setBackgroundResource(R.drawable.orange_brown);
                    textView2.setBackgroundResource(R.drawable.brown);
                    textView3.setBackgroundResource(R.drawable.pink);
                    textname1.setText("Orange and Brown");
                    textname2.setText("Pink !");

                    break;
                case "4":
                    showToast("THURSDAY");
                    textView.setBackgroundResource(R.drawable.blue);
                    textView2.setBackgroundResource(R.drawable.lighblue);
                    textView3.setBackgroundResource(R.drawable.purple);
                    textView4.setBackgroundResource(R.drawable.black);
                    textname1.setText("DarkBlue and Blue");
                    textname2.setText("Purple and Black !");
                    break;
                case "5":
                    showToast("FRIDAY");
                    textView.setBackgroundResource(R.drawable.yellow);
                    textView2.setBackgroundResource(R.drawable.white);
                    textView3.setBackgroundResource(R.drawable.lightpurple);
                    textname1.setText("Yellow and white");
                    textname2.setText("lightpurple !");

                    break;
                case "6":
                    showToast("SATURDAY");
                    textView.setBackgroundResource(R.drawable.lightpurple);

                    textView3.setBackgroundResource(R.drawable.green);
                    textname1.setText("LightPurple");
                    textname2.setText("green !");
                    break;
                case "7":
                    textView.setBackgroundResource(R.drawable.pink);
                    //textView2.setBackgroundResource(R.drawable.black);
                    textView3.setBackgroundResource(R.drawable.lighblue);
                    textView4.setBackgroundResource(R.drawable.blue);
                    textname1.setText("Pink");
                    textname2.setText("Darkblue and blue !");
                    showToast("SUNDAY");
                    break;
                default:
                    showToast("---INVALID---");
                    break;
            }
        }else if (value1.contentEquals("Engaging")) {

            imageView.setBackgroundResource(R.drawable.ic_engaging);
            switch (value2) {
                case "1":
                    textView.setBackgroundResource(R.drawable.lighblue);
                    //textView2.setBackgroundResource(R.drawable.brown);
                    textView3.setBackgroundResource(R.drawable.box);
                    textname1.setText("Darkblue");
                    textname2.setText("Red !");
                    showToast("MONDAY");
                    break;
                case "2":
                    textView.setBackgroundResource(R.drawable.box);
                    //textView2.setBackgroundResource(R.drawable.black);
                    textView3.setBackgroundResource(R.drawable.yellow);
                    textView3.setBackgroundResource(R.drawable.white);
                    textname1.setText("Purple and Black");
                    textname2.setText("Yellow and White !");
                    showToast("TUESDAY");
                    break;
                case "3":
                    showToast("WEDNESDAY");
                    textView.setBackgroundResource(R.drawable.grey);
                    textView2.setBackgroundResource(R.drawable.yellow);
                    textView3.setBackgroundResource(R.drawable.pink);
                    textname1.setText("Grey and yellow");
                    textname2.setText("Pink !");

                    break;
                case "4":
                    showToast("THURSDAY");
                    textView.setBackgroundResource(R.drawable.green);
                    //textView2.setBackgroundResource(R.drawable.lighblue);
                    textView3.setBackgroundResource(R.drawable.purple);
                    textView4.setBackgroundResource(R.drawable.black);
                    textname1.setText("Green");
                    textname2.setText("Purple and Black !");
                    break;
                case "5":
                    showToast("FRIDAY");
                    textView.setBackgroundResource(R.drawable.orange_brown);
                    textView2.setBackgroundResource(R.drawable.brown);
                    textView3.setBackgroundResource(R.drawable.lightpurple);
                    textname1.setText("orange and brown");
                    textname2.setText("lightpurple !");

                    break;
                case "6":
                    showToast("SATURDAY");
                    textView.setBackgroundResource(R.drawable.pink);

                    textView3.setBackgroundResource(R.drawable.green);
                    textname1.setText("Pink");
                    textname2.setText("green !");
                    break;
                case "7":
                    textView.setBackgroundResource(R.drawable.lightpurple);
                    //textView2.setBackgroundResource(R.drawable.black);
                    textView3.setBackgroundResource(R.drawable.lighblue);
                    textView4.setBackgroundResource(R.drawable.blue);
                    textname1.setText("LightPurple");
                    textname2.setText("Darkblue and blue !");
                    showToast("SUNDAY");
                    break;
                default:
                    showToast("---INVALID---");
                    break;
            }
        }else if (value1.contentEquals("Money")) {
            imageView.setBackgroundResource(R.drawable.ic_dollar);

            switch (value2) {
                case "1":
                    textView.setBackgroundResource(R.drawable.black);
                    textView2.setBackgroundResource(R.drawable.purple);
                    textView3.setBackgroundResource(R.drawable.box);
                    textname1.setText("Black and Purple");
                    textname2.setText("Red !");
                    showToast("MONDAY");
                    break;
                case "2":
                    textView.setBackgroundResource(R.drawable.orange_brown);
                    textView2.setBackgroundResource(R.drawable.brown);
                    textView3.setBackgroundResource(R.drawable.yellow);
                    textView3.setBackgroundResource(R.drawable.white);
                    textname1.setText("Orange and Brown");
                    textname2.setText("Yellow and White !");
                    showToast("TUESDAY");
                    break;
                case "3":
                    showToast("WEDNESDAY");
                    textView.setBackgroundResource(R.drawable.lighblue);
                    textView2.setBackgroundResource(R.drawable.yellow);
                    textView3.setBackgroundResource(R.drawable.pink);
                    textname1.setText("DarkBlue");
                    textname2.setText("Pink !");

                    break;
                case "4":
                    showToast("THURSDAY");
                    textView.setBackgroundResource(R.drawable.yellow);
                    textView2.setBackgroundResource(R.drawable.white);
                    textView3.setBackgroundResource(R.drawable.purple);
                    textView4.setBackgroundResource(R.drawable.black);
                    textname1.setText("Yellow and white");
                    textname2.setText("Purple and Black !");
                    break;
                case "5":
                    showToast("FRIDAY");
                    textView.setBackgroundResource(R.drawable.pink);
                    //textView2.setBackgroundResource(R.drawable.brown);
                    textView3.setBackgroundResource(R.drawable.lightpurple);
                    textname1.setText("Pink");
                    textname2.setText("lightpurple !");

                    break;
                case "6":
                    showToast("SATURDAY");
                    textView.setBackgroundResource(R.drawable.box);

                    textView3.setBackgroundResource(R.drawable.green);
                    textname1.setText("Red");
                    textname2.setText("green !");
                    break;
                case "7":
                    textView.setBackgroundResource(R.drawable.green);
                    //textView2.setBackgroundResource(R.drawable.black);
                    textView3.setBackgroundResource(R.drawable.lighblue);
                    textView4.setBackgroundResource(R.drawable.blue);
                    textname1.setText("Green ");
                    textname2.setText("Darkblue and blue !");
                    showToast("SUNDAY");
                    break;
                default:
                    showToast("---InValid---");
                    break;
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu3,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(this, ClothList.class);
                startActivity(intent);
                return true;
            case R.id.item0:
                Intent intent1 = new Intent(this, MainActivity2.class);
                startActivity(intent1);
                return true;
            case R.id.home:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    void showToast(String msg){
        Toast.makeText(Activity1.this,"Select day  = " + msg,Toast.LENGTH_LONG).show();
    }


    public void Act3(View view) {
        Intent intent = new Intent(Activity1.this,
                ClothList.class);
        startActivity(intent);


    }
}



