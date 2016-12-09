package fr.stri.ihm.awesomeconcert.awesomeconcert.adapter;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 22/11/2016.
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
