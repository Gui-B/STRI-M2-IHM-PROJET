package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.support.design.widget.Snackbar;
import android.view.View;

import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Artist;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Created by kriss on 12/12/16.
 */

public class BuyActivityViewModel extends DetailActivityViewModel {
    private Concert mConcert;
    private Artist mArtist;

    @Override
    protected String getMainTitle() {
        return mConcert.getConcertName();
    }

    @Override
    public String getSecondaryTitle() {
        return mArtist.getmName();
    }

    @Override
    public int getCoverRes() {
        return mArtist.getmPhotoRes();
    }

    @Override
    public String getMainText() {
        return mArtist.getmDesc();
    }

    @Override
    public void onBuyClicked(View v) {
        // achat  classique
        if (isLogged.get())
        {
            ValuesSingleton.getInstance().buyTicket(mConcert.getId());
            Snackbar.make(getRootView(), getString(R.string.detail_purchase_OK), Snackbar.LENGTH_SHORT).show();
            canBuyTicket.set(false);
        } else if () {
            // Récupération des infos de l'utilisateur

            // achat pour lui de la place
            ValuesSingleton.getInstance().buyTicket(mConcert.getId(), utilisateur à qui on offre);   buyTicket(mConcert.getId());
            Snackbar.make(getRootView(), getString(R.string.detail_purchase_OK), Snackbar.LENGTH_SHORT).show();
            // voir si il faut le conserver quand on l'offre ou si on considère apr défaut que la personne à qui on offre ne le possède pas déjà
            canBuyTicket.set(false);
        } else {
            Snackbar.make(getRootView(), getString(R.string.detail_purchase_error), Snackbar.LENGTH_SHORT).show();
        }
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
        return !ValuesSingleton.getInstance().hasTicket(mConcert.getId());
    }
}
