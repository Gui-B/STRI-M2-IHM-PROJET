package fr.stri.ihm.awesomeconcert.awesomeconcert.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.ActivityDetailBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.DetailActivityViewModel;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette activité permet l'affichage du détail d'autres activités. Il s'agit d'une classe abstraite permettant d'utiliser un layout commun.
 *
 * Seeheim : Partie traitement des données
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 24/11/2016
 */

public abstract class DetailActivity<VM extends DetailActivityViewModel> extends ViewModelActivity<ActivityDetailBinding, VM> {
    public static String KEY_ID = "_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    static Intent addConcertExtra(Intent i, int id) {
        i.putExtra(KEY_ID, id);
        return i;
    }
}
