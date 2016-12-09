package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.MainActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.FragmentConnexionBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.User;
import fr.stri.ihm.awesomeconcert.awesomeconcert.fragment.PasswordDialogFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 24/11/2016.
 */

public class ConnexionFragmentViewModel extends ViewModel<FragmentConnexionBinding> {
    public ObservableField<Boolean> completeProfile = new ObservableField<>(false);
    public ObservableField<String> buttonText = new ObservableField<>(getString(R.string.connexion_connection));
    public ObservableField<Boolean> isAccount = new ObservableField<>();
    public ObservableField<Boolean> confirmPasswd = new ObservableField<>();

    public void onClick(View v) {
        if (completeProfile.get()) {
            if (getBinding().passwdField.getText().toString().equals(getBinding().passwdField2.getText().toString())) {
                User user = new User(getBinding().loginField.getText().toString(),
                        getBinding().nameField.getText().toString(),
                        getBinding().lastNameField.getText().toString(),
                        getBinding().emailField.getText().toString(),
                        getBinding().passwdField.getText().toString());
                if (!user.getUserName().isEmpty() && !user.getName().isEmpty() && !user.getLastName().isEmpty() && !user.getMail().isEmpty() && !user.getPasswd().isEmpty())
                    ValuesSingleton.getInstance().signUp(user);
                ((MainActivity) getActivity()).getViewModel().navigateToExplore();
            } else {
                Snackbar.make(getRootView(), getString(R.string.connexion_passwd_no_match), Snackbar.LENGTH_SHORT).show();
            }
        } else {
            String user = getBinding().loginField.getText().toString();
            String passwd = getBinding().passwdField.getText().toString();
            if (ValuesSingleton.getInstance().logUserIn(user, passwd))
                ((MainActivity) getActivity()).getViewModel().navigateToExplore();
            else
                Snackbar.make(getRootView(), getString(R.string.connexion_passwd_invalid), Snackbar.LENGTH_SHORT).show();
        }
    }

    public void onSaveClick(View v) {
        ValuesSingleton.getInstance().updateUser(getBinding().loginField.getText().toString(),
                getBinding().nameField.getText().toString(),
                getBinding().lastNameField.getText().toString(),
                getBinding().emailField.getText().toString());
        ((MainActivity) getActivity()).getViewModel().navigateToExplore();
    }

    public void onPasswdEditClick(View v) {
        PasswordDialogFragment.newInstance().show(((AppCompatActivity) getActivity()).getSupportFragmentManager(), null);
    }

    public void setCompleteProfile(boolean completeProfile) {
        this.completeProfile.set(completeProfile);
        this.isAccount.set(completeProfile && ValuesSingleton.getInstance().isLoggedIn());
        this.confirmPasswd.set(completeProfile && !isAccount.get());
        buttonText.set(completeProfile ? getString(R.string.drawer_action_register) : getString(R.string.connexion_connection));
        if (isAccount.get()) {
            User user = ValuesSingleton.getInstance().getCurrentUser();
            getBinding().loginField.setText(user.getUserName());
            getBinding().nameField.setText(user.getName());
            getBinding().lastNameField.setText(user.getLastName());
            getBinding().emailField.setText(user.getPasswd());
        }
    }
}
