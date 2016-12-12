package fr.stri.ihm.awesomeconcert.awesomeconcert.fragment;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.DialogPasswordBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 29/11/2016.
 */
/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe correspond au fragment associé à la modification d'un mot de passe.
 *
 * Seeheim : Partie controleur de dialogue
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 29/11/2016
 */
public class PasswordDialogFragment extends DialogFragment {
    public static PasswordDialogFragment newInstance() {
        return new PasswordDialogFragment();
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View layout = getActivity().getLayoutInflater().inflate(R.layout.dialog_password, null);
        DialogPasswordBinding binding = DataBindingUtil.bind(layout);
        builder.setMessage("Modify password")
                .setView(layout)
                .setPositiveButton("Modify", (dialog, id) -> {
                    if (ValuesSingleton.getInstance().getCurrentUser().isPasswdMatch(binding.dialogPasswordOld.getText().toString())) {
                        if (binding.dialogPasswordNew.getText().toString().equals(binding.dialogPasswordNew2.getText().toString())) {
                            ValuesSingleton.getInstance().updatePassword(binding.dialogPasswordNew.getText().toString());
                            dismiss();
                        } else {
                            Toast.makeText(getContext(), "Password confirmation doesn't match password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "That's not your old password", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", (dialog, id) -> dismiss());
        return builder.create();
    }
}
