package fr.stri.ihm.awesomeconcert.awesomeconcert.activity;

import android.content.Context;
import android.content.Intent;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ArtistActivityViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.BuyActivityViewModel;

/**
 * Created by kriss on 12/12/16.
 */

public class BuyActivity extends DetailActivity<BuyActivityViewModel> {
    @Override
    public static Intent newIntent(Context context, int artistId) {
        Intent i = new Intent(context, ArtistActivity.class);
        return addConcertExtra(i, artistId);
    }

    @Override
    public ViewModelBindingConfig<BuyActivityViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_detail, BuyActivityViewModel.class);
    }
}
