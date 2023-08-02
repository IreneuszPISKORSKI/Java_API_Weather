package com.example.irek_api_java_weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btn_getBusStops, btn_getBusLines;
    EditText et_dataInput;
    ListView lv_weatherReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign values to each control on the layout
        btn_getBusStops = findViewById(R.id.btn_getBusStops);
        btn_getBusLines = findViewById(R.id.btn_getBusLines);
        et_dataInput = findViewById(R.id.et_dataInput);
        lv_weatherReports = findViewById(R.id.lv_weatherReports);

        // click listeners for each button
        btn_getBusStops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instantiate the RequestQueue
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "";


                Toast.makeText(MainActivity.this, "Click Get City ID. You wrote: " + et_dataInput.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btn_getBusLines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click Get Weather By City ID", Toast.LENGTH_SHORT).show();
            }
        });

    }


}