package fr.stri.ihm.awesomeconcert.awesomeconcert.utility;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.ImageView;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 28/11/2016.
 */

public class BindingUtils {
    @BindingAdapter({"bind:imageDrawable"})
    public static void setImage(ImageView view, @DrawableRes int drawableRes) {
        view.setImageDrawable(ContextCompat.getDrawable(view.getContext(), drawableRes));
    }

    @BindingAdapter({"bind:onCheckedChanged"})
    public static void setOnCheckedChangeListener(SwitchCompat switchCompat, CompoundButton.OnCheckedChangeListener listener) {
        switchCompat.setOnCheckedChangeListener(listener);
    }
}
