package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.ArtistActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.ConcertActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.DetailActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Artist;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 24/11/2016.
 */

public class ConcertActivityViewModel extends DetailActivityViewModel {
    private Concert mConcert;
    private Artist mArtist;


    @Override
    public String getMainTitle() {
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
        if(isLogged.get()) {
            ValuesSingleton.getInstance().buyTicket(mConcert.getId());
            Snackbar.make(getRootView(), getString(R.string.detail_purchase_OK), Snackbar.LENGTH_SHORT).show();
            canBuyTicket.set(false);
        } else {
            Snackbar.make(getRootView(), getString(R.string.detail_purchase_error), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNotificationsToggle(boolean checked) {
        ValuesSingleton.getInstance().notifyConcert(mConcert.getId(), checked);
    }

    @Override
    public void onPrimaryButtonClicked(View v) {
        getActivity().startActivity(ArtistActivity.newIntent(getContext(), mConcert.getArtistId()));
    }

    @Override
    public void onSecondaryButtonClicked(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=Le+zenith,+11+Avenue+Raymond+Badiou,+31300+Toulouse"));
        getActivity().startActivity(intent);
    }


    @Override
    protected boolean isConcert() {
        return true;
    }

    @Override
    protected void getDataFromIntent() {
        if (getActivity().getIntent().hasExtra(DetailActivity.KEY_ID)) {
            mConcert = ValuesSingleton.getInstance().getConcertById(getActivity().getIntent().getIntExtra(DetailActivity.KEY_ID, 0));
            mArtist = ValuesSingleton.getInstance().getArtistbyId(mConcert.getArtistId());
        } else {
            getActivity().finish();
        }
    }

    @Override
    protected boolean isChecked() {
        return ValuesSingleton.getInstance().notifEnabledConcert(mConcert.getId());
    }

    @Override
    protected boolean canBuyTicket() {
        return !ValuesSingleton.getInstance().hasTicket(mConcert.getId());
    }
}
