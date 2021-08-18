package com.example.belajarfan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainModels = new ArrayList<>();
        adapter = new MainAdapter(mainModels, this);
        recyclerView.setAdapter(adapter);


        getData();
    }

    private void getData() {
        AndroidNetworking.get("https://api.kawalcorona.com/indonesia/provinsi/")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject json = response.getJSONObject(i);
                                JSONObject json2 = json.getJSONObject("attributes");
                                String provinsi = json2.getString("Provinsi");
                                int kasus_posi = json2.getInt("Kasus_Posi");
                                int kasus_meni = json2.getInt("Kasus_Meni");
                                int kasus_semb = json2.getInt("Kasus_Semb");


                                mainModels.add(new MainModel(provinsi, kasus_posi, kasus_meni, kasus_semb));
                            }
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }
}