package com.example.pnattawut.mvppattern.presenter;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pnattawut.mvppattern.model.Thing;
import com.example.pnattawut.mvppattern.presenter.contract.MainContract;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PNattawut on 01-Oct-17.
 */

public class MainPresenter implements MainContract.Presenter {

    private Thing thing;
    private MainContract.View view;
    private Context context;
    Thing dpThing;

    public MainPresenter(MainContract.View view, Context context) {
        this.thing = new Thing();
        this.view = view;
        this.context = context;
    }

    @Override
    public void saveThing(Thing thing) {
        if (thing == null) {
            view.showError("Error! Thing is Nothing");
        }
        this.thing = thing;
    }

    @Override
    public Thing loadThing() {
        return this.thing;
    }

    @Override
    public void deleteThing() {
        this.thing = null;
    }

    private List<Thing> onlieThings;
    @Override
    public List<Thing> loadOnlineThings() {
        Volley.newRequestQueue(context)
                .add(new StringRequest(Request.Method.GET, "http://54.254.187.201:8080/Thing/things", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("$!!", response);
                        onlieThings = new Gson().fromJson(response, TypeToken.getParameterized(ArrayList.class, Thing.class).getType());
                        view.showThing(onlieThings.get(2));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("$!!", error.getMessage());
                    }
                }));
        return onlieThings;
    }
}
