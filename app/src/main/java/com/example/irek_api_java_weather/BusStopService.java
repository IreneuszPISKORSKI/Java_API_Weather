package com.example.irek_api_java_weather;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class BusStopService {
    String busNumbers;
    Context context;
    public static final String URL_BASE = "https://data.mobilites-m.fr/api/linesNear/json?x=";


    public BusStopService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String busNumbers);
    }

    public void getBusesInBusStop(String posX, String posY, VolleyResponseListener volleyResponseListener) {

        // Instantiate the RequestQueue
//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = URL_BASE + posX + "&y=" + posY;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                busNumbers = "";
                for (int i = 0; i < response.length(); i++) {
                    try {
                        busNumbers += response.getString(i) + " ";
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                volleyResponseListener.onResponse(busNumbers);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Error occured");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);

//        return busNumbers;
    }


    public interface BusListListener {
        void onError(String message);

        void onResponse(List<BusListModel> busListModels);
    }

    public void getListOfBus(String posX, String posY, BusListListener busListListener) {
        List<BusListModel> busListModels = new ArrayList<>();

        String url = URL_BASE + posX + "&y=" + posY;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                    try {
                            for (int i = 0; i < response.length(); i++) {
                                BusListModel one_bus = new BusListModel();
                                one_bus.setName(response.getString(i));
                                busListModels.add(one_bus);
                            }
                        busListListener.onResponse(busListModels);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();
                busListListener.onError("Error occured");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);

    }
}