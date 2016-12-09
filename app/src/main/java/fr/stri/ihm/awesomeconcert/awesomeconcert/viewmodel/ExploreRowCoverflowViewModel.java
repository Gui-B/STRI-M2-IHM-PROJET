package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.CoverflowAdapter;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.CoverflowItem;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.RowExploreCoverflowBinding;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 22/11/2016.
 */

public class ExploreRowCoverflowViewModel extends ViewModel<RowExploreCoverflowBinding> {

    public ExploreRowCoverflowViewModel(CoverflowItem mItem, CoverflowAdapter adapter) {
        adapter.setCoverflowItem(mItem);
    }
}
