package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.ConcertActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.MainActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.ExploreAdapter;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.StrategyItem;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.FragmentConcertListBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.fragment.ConcertListFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 22/11/2016.
 */

public class ConcertListFragmentViewModel extends ViewModel<FragmentConcertListBinding> implements OnItemClickedListener {
    @Override
	public void onViewAttached(boolean firstAttachment) {
		super.onViewAttached(firstAttachment);
		if(((ViewModelActivity)getActivity()).getViewModel() != null) {
            getBinding().exploreRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        }
	}

    @Override
    public void onConcertClicked(int concertId) {
        getActivity().startActivity(ConcertActivity.newIntent(getContext(), concertId));
    }

    public void setData(ConcertListFragment.Type type) {
        setData(type, 0);
    }

    public void setData(ConcertListFragment.Type type, int artistId) {
        List<StrategyItem> mItems;
        switch (type) {
            case ARTIST:
                mItems = ValuesSingleton.getInstance().generateConcertDataByArtistId(artistId, this);
                break;
            case NOTIFICATION:
                mItems = ValuesSingleton.getInstance().generateConcertsToNotify(this);
                break;
            case UPCOMING:
                mItems = ValuesSingleton.getInstance().generateUpcomingConcerts(this);
                break;
            default:
                mItems = ValuesSingleton.getInstance().generateExploreData(this);
        }
        getBinding().exploreRecycler.setAdapter(new ExploreAdapter(mItems));
    }
}
