package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.ConcertActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.ExploreAdapter;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.FragmentSearchBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 23/11/2016.
 */

public class SearchFragmentViewModel extends ViewModel<FragmentSearchBinding> implements OnItemClickedListener {
    private static final String TAG = "SearchFragmentViewModel";

    private static final int CONCERT = 1;
    private static final int ARTIST = 2;
    private static final int BOTH = 3;
    private static final int NONE = 4;

    private int mState = NONE;

    public ObservableField<Boolean> artists = new ObservableField<>();
    public ObservableField<Boolean> concerts = new ObservableField<>();

    @Override
    public void onViewAttached(boolean firstAttachment) {
        super.onViewAttached(firstAttachment);
        updateUI();
        ExploreAdapter mAdapter = new ExploreAdapter(ValuesSingleton.getInstance().generateSearchData(this));
        /*getBinding().searchArtistInput.setOnKeyListener((view, i, keyEvent) -> {
            if (!mCurrentArtistSearch.equals(getBinding().searchArtistInput.toString())) {
                mCurrentArtistSearch = getBinding().searchArtistInput.toString();
                mAdapter.refineArtist(mCurrentArtistSearch);
            }
            return false;
        });*/
        getBinding().searchResults.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        getBinding().searchResults.setAdapter(mAdapter);
    }


    @Override
    public void onConcertClicked(int id) {
        getActivity().startActivity(ConcertActivity.newIntent(getContext(), id));
    }


    public void onArtistTick(View v) {
        boolean ticked = getBinding().searchArtistCheckbox.isChecked();
        if(ticked) {
            switch (mState) {
                case CONCERT:
                    mState = BOTH;
                    break;
                case NONE:
                    mState = ARTIST;
                    break;
            }
        } else {
            switch (mState) {
                case BOTH:
                    mState = CONCERT;
                    break;
                case ARTIST:
                    mState = NONE;
                    break;
            }
        }
        updateUI();
    }


    public void onConcertTick(View v) {
        boolean ticked = getBinding().searchConcertCheckbox.isChecked();
        if(ticked) {
            switch (mState) {
                case ARTIST:
                    mState = BOTH;
                    break;
                case NONE:
                    mState = CONCERT;
                    break;
            }
        } else {
            switch (mState) {
                case BOTH:
                    mState = ARTIST;
                    break;
                case CONCERT:
                    mState = NONE;
                    break;
            }
        }
        updateUI();
    }

    private void updateUI(){
        switch (mState) {
            case ARTIST:
                artists.set(true);
                concerts.set(false);
                break;
            case CONCERT:
                artists.set(false);
                concerts.set(true);
                break;
            case BOTH:
                artists.set(true);
                concerts.set(true);
                break;
            case NONE:
                artists.set(true);
                concerts.set(true);
                break;
        }
    }
}
