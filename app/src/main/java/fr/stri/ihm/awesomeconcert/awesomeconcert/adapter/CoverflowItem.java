package fr.stri.ihm.awesomeconcert.awesomeconcert.adapter;

import java.util.List;

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
