package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static  CheckBox checkBox ;
    TextView editName, editPrice;
    private Button green;
    Button btnChoose, btnAdd, btnList, color;
    ImageView work, love, engage, money;
    EditText editText ;
    public static Spinner Day;


    final int REQUEST_CODE_GALLERY = 999;
    public static SQLiteHelper sqLiteHelper;
    public static String result_EXTRA = "";
    public static String dayOfTheWeek ,date;
    public static Integer isc = 0 ;
    public static String result_EXTRA2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        dayOfTheWeek = sdf.format(d);
        date = dayOfTheWeek ;
        editName= (TextView) findViewById(R.id.date);
        editName.setText(dayOfTheWeek);
        sqLiteHelper = new SQLiteHelper(this, "FoodDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD (Id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR, image BLOG)");
        money = (ImageView) findViewById(R.id.Money);
        work = (ImageView) findViewById(R.id.Work);
        engage = (ImageView) findViewById(R.id.Enaging);
        love = (ImageView) findViewById(R.id.Love);
        Day = (Spinner) findViewById(R.id.Day_array);




    }

    public void Money(View view) {

        Intent intent = new Intent(this, Activity1.class);
        String M = "Money";

        String M1 = "0";

        if (Day.getSelectedItem().equals("Monday")) {
            M1 = "1";

        } else if (Day.getSelectedItem().equals("Tuseday")){
            M1 = "2";

        }else if (Day.getSelectedItem().equals("Wednesday")){
            M1 = "3";

        }else if (Day.getSelectedItem().equals("Thursday")){
            M1 = "4";

        }else if (Day.getSelectedItem().equals("Friday")){
            M1 = "5";

        }else if (Day.getSelectedItem().equals("Saturday")){
            M1 = "6";

        }else if (Day.getSelectedItem().equals("Sunday")){
            M1 = "7";
        }

        intent.putExtra("key1", M);
        intent.putExtra("key2", M1);
        startActivity(intent);
    }


    public void Work(View view) {
        Intent intent = new Intent(this, Activity1.class);
        String M = "Work";

        String M1 = "0";

        if (Day.getSelectedItem().equals("Monday")) {
            M1 = "1";

        } else if (Day.getSelectedItem().equals("Tuseday")){
            M1 = "2";

        }else if (Day.getSelectedItem().equals("Wednesday")){
            M1 = "3";

        }else if (Day.getSelectedItem().equals("Thursday")){
            M1 = "4";

        }else if (Day.getSelectedItem().equals("Friday")){
            M1 = "5";

        }else if (Day.getSelectedItem().equals("Saturday")){
            M1 = "6";

        }else if (Day.getSelectedItem().equals("Sunday")){
            M1 = "7";
        }

        intent.putExtra("key1", M);
        intent.putExtra("key2", M1);
        startActivity(intent);
    }
    public void Engage(View view) {
        Intent intent = new Intent(this, Activity1.class);
        String M = "Engaging";

        String M1 = "0";

        if (Day.getSelectedItem().equals("Monday")) {
            M1 = "1";

        } else if (Day.getSelectedItem().equals("Tuseday")){
            M1 = "2";

        }else if (Day.getSelectedItem().equals("Wednesday")){
            M1 = "3";

        }else if (Day.getSelectedItem().equals("Thursday")){
            M1 = "4";

        }else if (Day.getSelectedItem().equals("Friday")){
            M1 = "5";

        }else if (Day.getSelectedItem().equals("Saturday")){
            M1 = "6";

        }else if (Day.getSelectedItem().equals("Sunday")){
            M1 = "7";
        }

        intent.putExtra("key1", M);
        intent.putExtra("key2", M1);
        startActivity(intent);
    }

    public void Love(View view) {
        Intent intent = new Intent(this, Activity1.class);
        String M = "Love";

        String M1 = "0";

        if (Day.getSelectedItem().equals("Monday")) {
            M1 = "1";

        } else if (Day.getSelectedItem().equals("Tuseday")){
            M1 = "2";

        }else if (Day.getSelectedItem().equals("Wednesday")){
            M1 = "3";

        }else if (Day.getSelectedItem().equals("Thursday")){
            M1 = "4";

        }else if (Day.getSelectedItem().equals("Friday")){
            M1 = "5";

        }else if (Day.getSelectedItem().equals("Saturday")){
            M1 = "6";

        }else if (Day.getSelectedItem().equals("Sunday")){
            M1 = "7";
        }

        intent.putExtra("key1", M);
        intent.putExtra("key2", M1);

        startActivity(intent);
    }

    public void web(View view) {

        Intent intent1 = new Intent(this, MainActivity2.class);
        startActivity(intent1);
}


}