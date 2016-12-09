package fr.stri.ihm.awesomeconcert.awesomeconcert.adapter;

import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 22/11/2016.
 */

public class ConcertItem extends StrategyItem {
	private Concert mConcert;
	private int mConcertId;
	private OnItemClickedListener mListener;

	public ConcertItem(int concertId, Concert concert, OnItemClickedListener listener) {
		super(TYPE_CONCERT);
		mConcert = concert;
		mListener = listener;
		mConcertId = concertId;
	}

	public Concert getConcert() {
		return mConcert;
	}

	public int getConcertId() {
		return mConcertId;
	}

	public OnItemClickedListener getListener(){
		return mListener;
	}
}
