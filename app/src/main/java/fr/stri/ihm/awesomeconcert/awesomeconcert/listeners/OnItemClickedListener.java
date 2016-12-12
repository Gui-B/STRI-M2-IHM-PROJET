package fr.stri.ihm.awesomeconcert.awesomeconcert.listeners;

import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe implémente l'action réalisé lorsqu'on clique sur un item
 *
 * Seeheim : Partie interface avec l'application
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 22/11/2016
 */
public interface OnItemClickedListener {
	void onConcertClicked(int concertId);
}
