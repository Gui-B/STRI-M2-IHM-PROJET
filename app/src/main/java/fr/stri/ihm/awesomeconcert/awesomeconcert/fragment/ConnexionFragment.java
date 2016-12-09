package fr.stri.ihm.awesomeconcert.awesomeconcert.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import cz.kinst.jakub.viewmodelbinding.ViewModelFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.FragmentConnexionBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ConnexionFragmentViewModel;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 24/11/2016.
 */

public class ConnexionFragment extends ViewModelFragment<FragmentConnexionBinding, ConnexionFragmentViewModel> {
    private static final String KEY_SIGNUP = "is_sign_up";

    public static ConnexionFragment newInstance(boolean isSignUp) {
        Bundle args = new Bundle();
        args.putBoolean(KEY_SIGNUP, isSignUp);
        ConnexionFragment fragment = new ConnexionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getViewModel().setCompleteProfile(getBundle().containsKey(KEY_SIGNUP) && getBundle().getBoolean(KEY_SIGNUP));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ViewModelBindingConfig<ConnexionFragmentViewModel> getViewModelBindingConfig() {
        return new ViewModelBindingConfig<>(R.layout.fragment_connexion, ConnexionFragmentViewModel.class);
    }
}
