package fr.stri.ihm.awesomeconcert.awesomeconcert.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.ActivityMainBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.MainActivityViewModel;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 24/11/2016.
 */

public class MainActivity extends ViewModelActivity<ActivityMainBinding, MainActivityViewModel> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onBackPressed() {
		if(!getViewModel().onBackPressed())
			super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

	
		return super.onOptionsItemSelected(item);
	}

	@Override
	public ViewModelBindingConfig<MainActivityViewModel> getViewModelBindingConfig() {
		return new ViewModelBindingConfig<>(R.layout.activity_main, MainActivityViewModel.class);
	}
}
