package com.example.madt1116;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvRates;
    private ArrayAdapter listAdapter;
    private ArrayList<String> currencyContentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvRates = findViewById(R.id.lvRates);
        this.currencyContentList = new ArrayList<String>();
        this.listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, currencyContentList);
        this.lvRates.setAdapter(this.listAdapter);
    }

    public void onBtnDownloadClick(View view) {
        currencyContentList.clear();
        currencyContentList.add("Loading...");
        listAdapter.notifyDataSetChanged();

        new DataLoader(){
            @Override
            public void onPostExecute(ArrayList<String> result)
            {
                currencyContentList.clear();
                currencyContentList.addAll(result);
                listAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}