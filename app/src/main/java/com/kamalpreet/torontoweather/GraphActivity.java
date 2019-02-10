package com.kamalpreet.torontoweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.kamalpreet.torontoweather.model.rest.APIClient;
import com.kamalpreet.torontoweather.model.rest.OpenWeatherUserEndPoint;
import com.kamalpreet.torontoweather.model.schema.OpenWeather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GraphActivity extends AppCompatActivity {


    private long Edate;
    private String date;
    private String[] sep;
    private int day;
    private LineChart lineChart;
    private ArrayList<Entry> entries;
    private double temperature;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        lineChart = (LineChart) findViewById(R.id.lineChart);
        entries = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        day = extras.getInt("date");


        final OpenWeatherUserEndPoint apiService = APIClient.getClient().create(OpenWeatherUserEndPoint.class);
        Call<OpenWeather> call = apiService.getUser("6167865","9e32b84116d7891d08a2f8513d6b77fe");
        call.enqueue(new Callback<OpenWeather>() {
            @Override
            public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response)
            {

                for(int i= 0; i<response.body().getWeatherLists().size(); i++)
                {
                    Edate  = Long.parseLong(response.body().getWeatherLists().get(i).getDate());
                    date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date (Edate*1000));
                    sep = date.split("/");
                    Log.d("Date is ", sep[0]);
                    temperature = Double.parseDouble(response.body().getWeatherLists().get(i).getWeather().getTemp())-273.15;

                    if(day == 0)  // User did't select any date
                    {

                        entries.add(new Entry(Float.parseFloat(sep[0]), (float) temperature));
                    }
                    else
                    {
                        if(day == Integer.parseInt(sep[0]))
                        {
                            entries.add(new Entry(Float.parseFloat(sep[0]), (float) temperature));
                        }
                    }


                }

                LineDataSet set = new LineDataSet(entries, "Set 1");
                set.setFillAlpha(110);
                ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
                iLineDataSets.add(set);

                LineData data = new LineData(iLineDataSets);
                lineChart.setData(data);

                lineChart.notifyDataSetChanged();
                lineChart.invalidate();



            }

            @Override
            public void onFailure(Call<OpenWeather> call, Throwable t)
            {
                Log.d("Failed", t.toString());
            }
        });

    }
}
