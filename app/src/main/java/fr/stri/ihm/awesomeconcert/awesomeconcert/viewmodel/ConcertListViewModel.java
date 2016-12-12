package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.ConcertActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.ConcertListActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.ActivityConcertListBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.fragment.ConcertListFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe implémente la vue d'une liste de concerts.
 *
 * Seeheim : Partie interface (présentation)
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 25/11/2016
 */

public class ConcertListViewModel extends ViewModel<ActivityConcertListBinding> implements OnItemClickedListener {

    @Override
    public void onViewAttached(boolean firstAttachment) {
        super.onViewAttached(firstAttachment);
        if (getActivity().getIntent().hasExtra(ConcertListActivity.KEY_ARTIST_ID)) {
            FragmentManager fm = ((AppCompatActivity) getActivity()).getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment_list_placeholder, ConcertListFragment.newInstance(getActivity().getIntent().getIntExtra(ConcertListActivity.KEY_ARTIST_ID, 0))).commit();
        }
    }

    @Override
    public void onConcertClicked(int concertId) {
        getActivity().startActivity(ConcertActivity.newIntent(getContext(), concertId));
    }
}
