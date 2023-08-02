package com.example.irek_api_java_weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_getCityID, btn_getWeatherByCityID, btn_getWeatherByCityName;
    EditText et_dataInput;
    ListView lv_weatherReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign values to each control on the layout
        btn_getCityID = findViewById(R.id.btn_getCityID);
        btn_getWeatherByCityID = findViewById(R.id.btn_getWeatherByCityID);
        btn_getWeatherByCityName = findViewById(R.id.btn_getWeatherByCityName);
        et_dataInput = findViewById(R.id.et_dataInput);
        lv_weatherReports = findViewById(R.id.lv_weatherReports);

        // click listeners for each button
        btn_getCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click Get City ID. You wrote: " + et_dataInput.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btn_getWeatherByCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click Get Weather By City ID", Toast.LENGTH_SHORT).show();
            }
        });
        btn_getWeatherByCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click Get Weather By City Name", Toast.LENGTH_SHORT).show();
            }
        });

    }


}