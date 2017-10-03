package com.example.pnattawut.mvppattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pnattawut.mvppattern.model.Thing;
import com.example.pnattawut.mvppattern.presenter.MainPresenter;
import com.example.pnattawut.mvppattern.presenter.contract.MainContract;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    TextView txtThingNameTextView;
    TextView txtThingTypeFormTextView;
    ImageView imgThing;
    private MainPresenter presenter;
    private RecyclerView recycleView;
    private RecyclerView.Adapter<ThingViewHolder> thingRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        recycleView = new RecyclerView(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        thingRecyclerAdapter = new RecyclerView.Adapter<ThingViewHolder>(){
            @Override
            public ThingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View thingCard = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_main, parent, false);
                return new ThingViewHolder(thingCard);
            }

            @Override
            public void onBindViewHolder(ThingViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 2000;
            }
        };
        recycleView.setAdapter(thingRecyclerAdapter);
        setContentView(recycleView);


        txtThingNameTextView = (TextView) findViewById(R.id.txtThing);
        txtThingTypeFormTextView = (TextView) findViewById(R.id.txtType);
        imgThing = (ImageView) findViewById(R.id.imgThing);

    }

    @Override
    protected void onStart() {
        super.onStart();
//        presenter = new MainPresenter(this, this);
//        presenter.loadOnlineThings();
//        //presenter.saveThing(null); // <-- MAKE Thing is Nothing!
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


    class ThingViewHolder extends RecyclerView.ViewHolder {
        public ThingViewHolder(View itemView) {
            super(itemView);
        }
    }
}
