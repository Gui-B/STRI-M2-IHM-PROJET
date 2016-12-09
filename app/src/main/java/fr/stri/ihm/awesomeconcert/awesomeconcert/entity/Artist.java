package fr.stri.ihm.awesomeconcert.awesomeconcert.entity;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 25/11/2016.
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
