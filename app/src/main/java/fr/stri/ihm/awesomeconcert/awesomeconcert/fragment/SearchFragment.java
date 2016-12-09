package fr.stri.ihm.awesomeconcert.awesomeconcert.fragment;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import cz.kinst.jakub.viewmodelbinding.ViewModelFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.FragmentSearchBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.SearchFragmentViewModel;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 23/11/2016.
 */

public class SearchFragment extends ViewModelFragment<FragmentSearchBinding, SearchFragmentViewModel> {
    @Override
    public ViewModelBindingConfig<SearchFragmentViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.fragment_search, SearchFragmentViewModel.class);
    }
}
