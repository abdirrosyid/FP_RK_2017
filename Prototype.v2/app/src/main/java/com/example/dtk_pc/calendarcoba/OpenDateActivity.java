package com.example.dtk_pc.calendarcoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OpenDateActivity extends AppCompatActivity {

    private TextView theDate;
    private Button btnGoCal;
    Button save;
    ArrayList<String> addArray = new ArrayList<String>();
    EditText txt;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_date);
        theDate = (TextView) findViewById(R.id.date);
        btnGoCal = (Button) findViewById(R.id.btnGoCal);
        txt = (EditText) findViewById(R.id.inputAgenda);
        show = (ListView) findViewById(R.id.listView);
        save = (Button) findViewById(R.id.addAgenda);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();
            if (addArray.contains(getInput)){
                Toast.makeText(getBaseContext(), "Agenda added", Toast.LENGTH_LONG).show();
            }
            else if (getInput == null || getInput.trim().equals("")){
                Toast.makeText(getBaseContext(), "Input is Empty", Toast.LENGTH_LONG).show();
            }
            else {
                addArray.add(getInput);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(OpenDateActivity.this, android.R.layout.simple_list_item_1, addArray);
                show.setAdapter(adapter);
                ((EditText)findViewById(R.id.inputAgenda)).setText(" ");
            }
            }
        });

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);

        btnGoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpenDateActivity.this, CalendarActivity.class);
                startActivity(intent);

            }
        });

    }
}
