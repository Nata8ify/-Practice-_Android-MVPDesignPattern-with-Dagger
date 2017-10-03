package com.example.pnattawut.mvppattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pnattawut.mvppattern.model.Thing;
import com.example.pnattawut.mvppattern.presenter.MainPresenter;
import com.example.pnattawut.mvppattern.presenter.contract.MainContract;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    TextView txtThingNameTextView;
    TextView txtThingTypeFormTextView;
    ImageView imgThing;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtThingNameTextView = (TextView) findViewById(R.id.txtThing);
        txtThingTypeFormTextView = (TextView) findViewById(R.id.txtType);
        imgThing = (ImageView) findViewById(R.id.imgThing);

        presenter = new MainPresenter(this, this);
        presenter.loadOnlineThings();
        //presenter.saveThing(null); // <-- MAKE Thing is Nothing!
    }

    // -> Present Implementation
    @Override
    public void showHello(String thing) {
        txtThingNameTextView.setText("Hello! ".concat(thing));
    }

    @Override
    public void showThing(Thing thing) {
        Picasso.with(this).load(thing.getUrl()).into(imgThing);
        txtThingNameTextView.setText(thing.getName());
        txtThingTypeFormTextView.setText(thing.getType().concat(" (").concat(thing.getForm()).concat(")"));
    }

    @Override
    public void showError(String err) {
        txtThingNameTextView.setText(err);
    }

    //  <- Present Implementation

}
