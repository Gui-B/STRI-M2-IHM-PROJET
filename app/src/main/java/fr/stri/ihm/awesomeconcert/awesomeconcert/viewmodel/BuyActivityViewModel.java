package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.view.View;

/**
 * Created by kriss on 12/12/16.
 */

public class BuyActivityViewModel extends DetailActivityViewModel {
    @Override
    protected String getMainTitle() {
        return null;
    }

    @Override
    public String getSecondaryTitle() {
        return null;
    }

    @Override
    public int getCoverRes() {
        return 0;
    }

    @Override
    public String getMainText() {
        return null;
    }

    @Override
    public void onBuyClicked(View v) {

    }

    @Override
    public void onNotificationsToggle(boolean isChecked) {

    }

    @Override
    public void onPrimaryButtonClicked(View v) {

    }

    @Override
    public void onSecondaryButtonClicked(View v) {

    }

    @Override
    protected boolean isConcert() {
        return false;
    }

    @Override
    protected void getDataFromIntent() {

    }

    @Override
    protected boolean isChecked() {
        return false;
    }

    @Override
    protected boolean canBuyTicket() {
        return false;
    }
}
