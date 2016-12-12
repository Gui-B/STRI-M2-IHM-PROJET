package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.ActivityDetailBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe implémente la vue associé à l'affichage du détail d'une activité.
 *
 * Seeheim : Partie interface (présentation)
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 24/11/2016
 */

public abstract class DetailActivityViewModel extends ViewModel<ActivityDetailBinding> {
    public ObservableField<Boolean> isConcert = new ObservableField<>(true);
    public ObservableField<Boolean> isChecked = new ObservableField<>();
    public ObservableField<Boolean> isLogged = new ObservableField<>();
    public ObservableField<Boolean> canBuyTicket = new ObservableField<>();

    @Override
    public void onViewAttached(boolean firstAttachment) {
        super.onViewAttached(firstAttachment);
        getDataFromIntent();
        isConcert.set(isConcert());
        isChecked.set(isChecked());
        isLogged.set(ValuesSingleton.getInstance().isLoggedIn());
        canBuyTicket.set(canBuyTicket());

        Toolbar toolbar = getBinding().activityConcertToolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        try {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        getBinding().activityConcertCollapsingToolbar.setTitle(getMainTitle());
    }

    @Bindable
    protected abstract String getMainTitle();

    @Bindable
    public abstract String getSecondaryTitle();

    @Bindable
    public abstract int getCoverRes();

    @Bindable
    public abstract String getMainText();

    public abstract void onBuyClicked(View v);

    public abstract void onNotificationsToggle(boolean isChecked);

    public abstract void onPrimaryButtonClicked(View v);

    public abstract void onSecondaryButtonClicked(View v);

    protected abstract boolean isConcert();

    protected abstract void getDataFromIntent();

    protected abstract boolean isChecked();

    protected abstract boolean canBuyTicket();
}
