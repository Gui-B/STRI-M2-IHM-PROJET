package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.databinding.Bindable;
import android.view.View;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.ItemRowExploreCoverflowBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Artist;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 22/11/2016.
 */

public class ExploreRowCoverflowItemViewModel extends ViewModel<ItemRowExploreCoverflowBinding> {
	private Concert mConcert;
	private Artist mArtist;
	private OnItemClickedListener mListener;

	public ExploreRowCoverflowItemViewModel(Concert mConcert, OnItemClickedListener mListener) {
		this.mConcert = mConcert;
		this.mListener = mListener;
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
    public String getDate() {
        return mConcert.getConcertDate();
    }

	public void onItemClicked(View v) {
		mListener.onConcertClicked(mConcert.getId());
	}
}
