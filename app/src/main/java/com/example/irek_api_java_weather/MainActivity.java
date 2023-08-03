package com.example.irek_api_java_weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_getBusStops, btn_getBusLines;
    EditText et_dataInput, et_dataInput_2;
    ListView lv_busResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign values to each control on the layout
        btn_getBusStops = findViewById(R.id.btn_getBusStops);
        btn_getBusLines = findViewById(R.id.btn_getBusLines);
        et_dataInput = findViewById(R.id.et_dataInput);
        et_dataInput_2 = findViewById(R.id.et_dataInput_2);
        lv_busResults = findViewById(R.id.lv_busResults);

        final BusStopService busStopService = new BusStopService(MainActivity.this);

        // click listeners for each button
        btn_getBusStops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busStopService.getListOfBus(et_dataInput.getText().toString(), et_dataInput_2.getText().toString(), new BusStopService.BusListListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<BusListModel> busListModel) {

                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, busListModel);
                        lv_busResults.setAdapter(arrayAdapter);

//                        Toast.makeText(MainActivity.this, busListModel.toString(), Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });


        btn_getBusLines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busStopService.getBusesInBusStop(et_dataInput.getText().toString(), et_dataInput_2.getText().toString(), new BusStopService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String busNumbers) {
                        Toast.makeText(MainActivity.this, busNumbers, Toast.LENGTH_SHORT).show();
                    }
                }) ;
            }
        });

    }


}