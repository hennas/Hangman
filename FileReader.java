package com.example.myfirstapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private Context context;

    public FileReader(Context context) {
        this.context = context;
    }

    public List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();
        AssetManager assetM = context.getAssets();
        try {
            InputStream inputS = assetM.open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputS));
            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
