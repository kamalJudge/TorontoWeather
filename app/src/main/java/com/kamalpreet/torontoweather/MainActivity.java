package com.kamalpreet.torontoweather;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView tv_selectDate;
    private Button getWeather, resetDate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private int date;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_selectDate = findViewById(R.id.tv_start);
        getWeather = findViewById(R.id.button);
        resetDate = findViewById(R.id.button2);

        tv_selectDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_MinWidth, onDateSetListener, year, month, day);
                dialog.show();
            }
        });




        onDateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month+1;
                date = day;
                tv_selectDate.setText("Date : "+day+"/"+month+"/"+year);
            }
        };

        getWeather.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

        resetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                date = 0;
                tv_selectDate.setText("Select Date : ");
            }
        });
    }

}
