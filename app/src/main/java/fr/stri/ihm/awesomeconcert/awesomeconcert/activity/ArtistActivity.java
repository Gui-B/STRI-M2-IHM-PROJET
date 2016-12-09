package fr.stri.ihm.awesomeconcert.awesomeconcert.activity;

import android.content.Context;
import android.content.Intent;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ArtistActivityViewModel;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 24/11/2016.
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
