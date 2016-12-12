package fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import cz.kinst.jakub.viewmodelbinding.ViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.activity.MainActivity;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.ActivityMainBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.fragment.ConcertListFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.fragment.ConnexionFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.fragment.SearchFragment;
import fr.stri.ihm.awesomeconcert.awesomeconcert.singleton.ValuesSingleton;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe implémente la vue principale.
 *
 * Seeheim : Partie interface (présentation)
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 22/11/2016
 */

public class MainActivityViewModel extends ViewModel<ActivityMainBinding> implements NavigationView.OnNavigationItemSelectedListener {
	private FragmentManager mFM;

	@Override
	public void onViewAttached(boolean firstAttachment) {
		super.onViewAttached(firstAttachment);
		connectUser();

		Toolbar toolbar = getBinding().appBarMain.toolbar;
		((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

		DrawerLayout drawer = getBinding().drawerLayout;
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = getBinding().navView;
		navigationView.setNavigationItemSelectedListener(this);

		mFM = ((AppCompatActivity) getActivity()).getSupportFragmentManager();
		mFM.beginTransaction().replace(R.id.fragment_placeholder, ConcertListFragment.newInstance()).commit();
	}

	@Override
	public void onViewDetached(boolean finalDetachment) {
		super.onViewDetached(finalDetachment);
	}


	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();
		switch (id) {
			case R.id.nav_search:
				mFM.beginTransaction().replace(R.id.fragment_placeholder, new SearchFragment()).commit();
				break;
			case R.id.nav_sign_in:
				mFM.beginTransaction().replace(R.id.fragment_placeholder, ConnexionFragment.newInstance(false)).commit();
				break;
			case R.id.nav_sign_up:
				mFM.beginTransaction().replace(R.id.fragment_placeholder, ConnexionFragment.newInstance(true)).commit();
				break;
			case R.id.nav_concerts:
				mFM.beginTransaction().replace(R.id.fragment_placeholder, ConcertListFragment.newUpcomingInstance()).commit();
				break;
			case R.id.nav_notification:
				mFM.beginTransaction().replace(R.id.fragment_placeholder, ConcertListFragment.newNotificationInstance()).commit();
				break;
			case R.id.nav_account:
				mFM.beginTransaction().replace(R.id.fragment_placeholder, ConnexionFragment.newInstance(true)).commit();
				break;
			case R.id.nav_all_concerts:
                mFM.beginTransaction().replace(R.id.fragment_placeholder, ConcertListFragment.newInstance()).commit();
				break;
			case R.id.nav_logout:
				ValuesSingleton.getInstance().logUserOut();
                ((MainActivity) getActivity()).getViewModel().navigateToExplore();

                break;
		}

		DrawerLayout drawer = getBinding().drawerLayout;
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}


	/**
	 *
	 * @return true if the back event is consumed, false otherwise
	 */
	public boolean onBackPressed() {
		DrawerLayout drawer = getBinding().drawerLayout;
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
			return true;
		} else {
			return false;
		}
	}

    void navigateToExplore() {
        getBinding().navView.setCheckedItem(R.id.nav_all_concerts);
        connectUser();
        mFM.beginTransaction().replace(R.id.fragment_placeholder, ConcertListFragment.newInstance()).commit();
        DrawerLayout drawer = getBinding().drawerLayout;
        drawer.closeDrawer(GravityCompat.START);
    }


	private void connectUser() {
		Menu menu = getBinding().navView.getMenu();
		for(int i = 0; i < menu.size(); i++) {
			MenuItem item = menu.getItem(i);
			item.setVisible(isMenuItemVisible(item, ValuesSingleton.getInstance().isLoggedIn()));
		}
	}

	private boolean isMenuItemVisible(MenuItem item, boolean connected) {
		switch (item.getItemId()) {
			case R.id.nav_account:
			case R.id.nav_notification:
			case R.id.nav_logout:
			case R.id.nav_concerts:
				return connected;
			case R.id.nav_sign_in:
			case R.id.nav_sign_up:
				return !connected;
			default:
				return true;
		}
	}
}
