package fr.stri.ihm.awesomeconcert.awesomeconcert.adapter;

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
public abstract class StrategyItem {
	public static final int TYPE_COVERFLOW = 0;
	public static final int TYPE_CONCERT = 1;

	private int mType;

	StrategyItem(int type) {
		mType = type;
	}

	public int getType() {
		return mType;
	}
}
