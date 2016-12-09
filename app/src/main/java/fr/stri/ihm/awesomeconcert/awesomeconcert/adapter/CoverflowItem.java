package fr.stri.ihm.awesomeconcert.awesomeconcert.adapter;

import java.util.List;

import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 22/11/2016.
 */

public class CoverflowItem extends StrategyItem {
	private List<Concert> mConcerts;
	private OnItemClickedListener mListener;

	public CoverflowItem(List<Concert> mConcerts, OnItemClickedListener mListener) {
		super(TYPE_COVERFLOW);
		this.mConcerts = mConcerts;
		this.mListener = mListener;
	}

    public List<Concert> getmConcerts() {
        return mConcerts;
    }

    public OnItemClickedListener getmListener() {
        return mListener;
    }
}
