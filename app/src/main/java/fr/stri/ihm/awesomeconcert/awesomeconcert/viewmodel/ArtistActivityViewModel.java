package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.view.View;
import android.widget.Toast;

import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.ConcertListActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.DetailActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Artist;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 24/11/2016.
 */

public class ArtistActivityViewModel extends DetailActivityViewModel {
    private Artist mArtist;
    private int mArtistId;

    @Override
    public String getMainTitle() {
        return mArtist.getmName();
    }

    @Override
    public String getSecondaryTitle() {
        return null;
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
    public void onBuyClicked(View v) {}

    @Override
    public void onNotificationsToggle(boolean checked) {
        ValuesSingleton.getInstance().notifArtist(mArtistId, checked);
    }

    @Override
    public void onPrimaryButtonClicked(View v) {
        getActivity().startActivity(ConcertListActivity.getIntent(getContext(), mArtistId));
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
        if (getActivity().getIntent().hasExtra(DetailActivity.KEY_ID)) {
            mArtistId = getActivity().getIntent().getIntExtra(DetailActivity.KEY_ID, 0);
            mArtist = ValuesSingleton.getInstance().getArtistbyId(mArtistId);
        } else {
            getActivity().finish();
        }
    }

    @Override
    protected boolean isChecked() {
        return ValuesSingleton.getInstance().notifEnabledArtist(mArtistId);
    }

    @Override
    protected boolean canBuyTicket() {
        return false;
    }
}
