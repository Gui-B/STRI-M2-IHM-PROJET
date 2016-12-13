package fr.stri.ihm.awesomeconcert.awesomeconcert.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Set;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import cz.kinst.jakub.viewmodelbinding.ViewModelFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.FragmentConcertListBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ConcertListFragmentViewModel;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe correspond au fragment assicié à la liste des concert.
 *
 * Seeheim : Partie controleur de dialogue
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 22/11/2016
 */

public class ConcertListFragment extends ViewModelFragment<FragmentConcertListBinding, ConcertListFragmentViewModel> {
    private static final String KEY_ARTIST_ID = "artistId";
    private static final String KEY_NOTIFICATION = "notifications";

	public enum Type {
		EXPLORE,
		ARTIST,
		NOTIFICATION,
		UPCOMING
	}

	public static ConcertListFragment newInstance() {
		Bundle args = new Bundle();
		ConcertListFragment fragment = new ConcertListFragment();
		fragment.setArguments(args);
		return fragment;
	}

	public static ConcertListFragment newInstance(int artistId) {
		Bundle args = new Bundle();
		args.putInt(KEY_ARTIST_ID, artistId);
		ConcertListFragment fragment = new ConcertListFragment();
		fragment.setArguments(args);
		return fragment;
	}

	public static ConcertListFragment newNotificationInstance() {
		Bundle args = new Bundle();
		args.putBoolean(KEY_NOTIFICATION, true);
		ConcertListFragment fragment = new ConcertListFragment();
		fragment.setArguments(args);
		return fragment;
	}

    public static ConcertListFragment newUpcomingInstance() {
        Bundle args = new Bundle();
        args.putBoolean(KEY_NOTIFICATION, false);
        ConcertListFragment fragment = new ConcertListFragment();
        fragment.setArguments(args);
        return fragment;
    }

	@Override
	public ViewModelBindingConfig<ConcertListFragmentViewModel> getViewModelBindingConfig() {
		return new ViewModelBindingConfig<>(R.layout.fragment_concert_list, ConcertListFragmentViewModel.class);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        try {
            Set<String> keys = getBundle().keySet();
            if (keys.contains(KEY_NOTIFICATION))
                if (getBundle().getBoolean(KEY_NOTIFICATION))
                    getViewModel().setData(Type.NOTIFICATION);
                else
                    getViewModel().setData(Type.UPCOMING);
            else if (keys.contains(KEY_ARTIST_ID))
                getViewModel().setData(Type.ARTIST, getBundle().getInt(KEY_ARTIST_ID));
            else getViewModel().setData(Type.EXPLORE);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
	}
}
