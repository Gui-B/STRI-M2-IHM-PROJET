package fr.stri.ihm.awesomeconcert.awesomeconcert.activity;

import android.content.Context;
import android.content.Intent;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ConcertActivityViewModel;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette activité est destinée pour l'affichage d'un concert. Elle hérite de DetailActivity.
 *
 * Seeheim : Partie traitement des données
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 24/11/2016
 */

public class ConcertActivity extends DetailActivity<ConcertActivityViewModel> {
    public static Intent newIntent(Context context, int concertId) {
        Intent i = new Intent(context, ConcertActivity.class);
        return addConcertExtra(i, concertId);
    }

    @Override
    public ViewModelBindingConfig<ConcertActivityViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_detail, ConcertActivityViewModel.class);
    }
}
