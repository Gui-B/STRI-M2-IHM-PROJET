package fr.stri.ihm.awesomeconcert.awesomeconcert.activity;

import android.content.Context;
import android.content.Intent;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ConcertActivityViewModel;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 24/11/2016.
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
