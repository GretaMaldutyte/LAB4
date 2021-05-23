package com.example.madt1116;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class DataLoader extends AsyncTask<ArrayList<String>, Void, ArrayList<String>> {

    protected ArrayList<String> doInBackground(ArrayList<String>... params) {
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
        }

        return new ArrayList<String>();
    }
}