package com.example.pnattawut.mvppattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pnattawut.mvppattern.model.Thing;
import com.example.pnattawut.mvppattern.presenter.MainPresenter;
import com.example.pnattawut.mvppattern.presenter.contract.MainContract;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    TextView txtThingTextView;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtThingTextView = (TextView)findViewById(R.id.txtThing);
        presenter = new MainPresenter(this);
        presenter.saveThing(new Thing(){{
            setMarkInt(1);
            setName("Mars");
            setForm("Planet");
        }});
        showThing(presenter.loadThing());
        showHello(presenter.loadThing().getName());
        presenter.saveThing(null); // <-- MAKE Thing is Nothing!
    }

    // -> Present Implementation
    @Override
    public void showHello(String thing) {
        txtThingTextView.setText("Hello! ".concat(thing));
    }

    @Override
    public void showThing(Thing thing) {
        txtThingTextView.setText(thing.toString());
    }

    @Override
    public void showError(String err) {
        txtThingTextView.setText(err);
    }

    //  <- Present Implementation

}
