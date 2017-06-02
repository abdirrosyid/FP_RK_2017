package com.example.dtk_pc.calendarcoba;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;

/**
 * Created by DTK-PC on 6/1/2017.
 */

public class CalendarActivity extends AppCompatActivity {
    private static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int i, int i1, int i2) {
                String date = i2 +"/" + (i1+1) + "/" + i;
                Log.d(TAG, "onSelectedDayChange: date: " + date);

                Intent intent = new Intent(CalendarActivity.this, OpenDateActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}
