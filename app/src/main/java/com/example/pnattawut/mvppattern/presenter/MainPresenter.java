package com.example.pnattawut.mvppattern.presenter;

import com.example.pnattawut.mvppattern.model.Thing;
import com.example.pnattawut.mvppattern.presenter.contract.MainContract;

/**
 * Created by PNattawut on 01-Oct-17.
 */

public class MainPresenter implements MainContract.Presenter {

    private Thing thing;
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.thing = new Thing();
        this.view = view;
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
}
