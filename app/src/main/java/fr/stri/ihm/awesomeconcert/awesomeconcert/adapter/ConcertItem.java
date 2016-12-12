package fr.stri.ihm.awesomeconcert.awesomeconcert.adapter;

import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;


/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe est responsable de faire la vue pour chacun des items du dateset.
 *
 * Seeheim : Partie traitement des données
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 22/11/2016
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
