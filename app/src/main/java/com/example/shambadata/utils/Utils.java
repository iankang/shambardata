package com.example.shambadata.utils;

import android.content.Context;

import com.example.shambadata.models.LiveStockBreedResponse;
import com.example.shambadata.models.LiveStockCategoryResponse;
import com.example.shambadata.models.ShambaDataResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import kotlin.reflect.KClass;

public class Utils {
    public static ShambaDataResponse getShambaDataJsonFromAssets(Context context, String fileName) {
        String jsonString;
        ShambaDataResponse theInput;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");

            Gson gson = new Gson();
            Type theType = new TypeToken<ShambaDataResponse>(){}.getType();
            theInput = gson.fromJson(jsonString, theType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return theInput;
    }

    public static LiveStockBreedResponse getLiveStockBreedDataJsonFromAssets(Context context, String fileName) {
        String jsonString;
        LiveStockBreedResponse theInput;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");

            Gson gson = new Gson();
            Type theType = new TypeToken<LiveStockBreedResponse>(){}.getType();
            theInput = gson.fromJson(jsonString, theType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return theInput;
    }

    public static LiveStockCategoryResponse getLiveStockCategoriesDataJsonFromAssets(Context context, String fileName) {
        String jsonString;
        LiveStockCategoryResponse theInput;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");

            Gson gson = new Gson();
            Type theType = new TypeToken<LiveStockCategoryResponse>(){}.getType();
            theInput = gson.fromJson(jsonString, theType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return theInput;
    }
}