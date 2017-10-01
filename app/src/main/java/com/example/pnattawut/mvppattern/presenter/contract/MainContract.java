package com.example.pnattawut.mvppattern.presenter.contract;

import com.example.pnattawut.mvppattern.model.Thing;

/**
 * Created by PNattawut on 01-Oct-17.
 */

public interface MainContract {
    interface View {
        void showHello(String thing);
        void showThing(Thing thing);
        void showError(String err);
    }

    interface Presenter {
        void saveThing(Thing thing);
        Thing loadThing();
        void deleteThing();
    }
}
