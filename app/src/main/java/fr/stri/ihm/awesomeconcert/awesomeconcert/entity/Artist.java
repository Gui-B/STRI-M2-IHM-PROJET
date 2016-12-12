package fr.stri.ihm.awesomeconcert.awesomeconcert.entity;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe correspond à un artiste.
 *
 * Seeheim : Partie traitement des données
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 25/11/2016
 */

public class Artist {
    private String mName;
    private int mPhotoRes;
    private String mDesc;

    public Artist(String mName, int mPhotoRes, String mDesc) {
        this.mName = mName;
        this.mPhotoRes = mPhotoRes;
        this.mDesc = mDesc;
    }

    public String getmName() {
        return mName;
    }

    public int getmPhotoRes() {
        return mPhotoRes;
    }

    public String getmDesc() {
        return mDesc;
    }
}
