package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.databinding.Bindable;
import android.view.View;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.ConcertItem;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.RowExploreConcertBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Artist;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe implémente la vue associé à un concert.
 *
 * Seeheim : Partie interface (présentation)
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 22/11/2016
 */

public class ExploreRowConcertViewModel extends ViewModel<RowExploreConcertBinding> {
    private Concert mConcert;
    private Artist mArtist;
    private OnItemClickedListener mListener;
    private int mConcertId;

    public ExploreRowConcertViewModel(ConcertItem concertItem) {
        this.mConcert = concertItem.getConcert();
        this.mListener = concertItem.getListener();
        this.mConcertId = concertItem.getConcertId();
        this.mArtist = ValuesSingleton.getInstance().getArtistbyId(mConcert.getArtistId());
    }

    @Override
    public void onViewAttached(boolean firstAttachment) {
        super.onViewAttached(firstAttachment);
    }

    @Bindable
    public int getCoverRes() {
        return mArtist.getmPhotoRes();
    }

    @Bindable
    public String getName() {
        return mConcert.getConcertName();
    }

    @Bindable
    public String getArtist() {
        return mArtist.getmName();
    }

    @Bindable
    public String getDate() {
        return mConcert.getConcertDate();
    }

    public void onItemClicked(View v) {
        mListener.onConcertClicked(mConcertId);
    }
}
