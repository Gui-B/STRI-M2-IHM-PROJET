package fr.stri.ihm.awesomeconcert.awesomeconcert.activity;

import android.content.Context;
import android.content.Intent;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ArtistActivityViewModel;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette activité permet l'affichage d'un artiste. Elle hérite de DetailActivity.
 *
 * Seeheim : Partie traitement des données
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 24/11/2016
 */

public class ArtistActivity extends DetailActivity<ArtistActivityViewModel> {
    public static Intent newIntent(Context context, int artistId) {
        Intent i = new Intent(context, ArtistActivity.class);
        return addConcertExtra(i, artistId);
    }

    @Override
    public ViewModelBindingConfig<ArtistActivityViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_detail, ArtistActivityViewModel.class);
    }
}
