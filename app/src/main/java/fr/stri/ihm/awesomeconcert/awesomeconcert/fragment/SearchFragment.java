package fr.stri.ihm.awesomeconcert.awesomeconcert.fragment;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import cz.kinst.jakub.viewmodelbinding.ViewModelFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.FragmentSearchBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.SearchFragmentViewModel;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe correspond au fragment associé à une recherche.
 *
 * Seeheim : Partie controleur de dialogue
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 23/11/2016
 */

public class SearchFragment extends ViewModelFragment<FragmentSearchBinding, SearchFragmentViewModel> {
    @Override
    public ViewModelBindingConfig<SearchFragmentViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.fragment_search, SearchFragmentViewModel.class);
    }
}
