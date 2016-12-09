package fr.stri.ihm.awesomeconcert.awesomeconcert.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.ActivityConcertListBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ConcertListViewModel;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 25/11/2016.
 */

public class ConcertListActivity extends ViewModelActivity<ActivityConcertListBinding, ConcertListViewModel> {
    public static String KEY_ARTIST_ID = "artist_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static Intent getIntent(Context context, int artistId) {
        Intent i = new Intent(context, ConcertListActivity.class);
        i.putExtra(KEY_ARTIST_ID, artistId);
        return i;
    }

    @Override
    public ViewModelBindingConfig<ConcertListViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.activity_concert_list, ConcertListViewModel.class);
    }
}
