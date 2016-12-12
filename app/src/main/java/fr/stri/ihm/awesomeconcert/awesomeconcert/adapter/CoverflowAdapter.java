package fr.stri.ihm.awesomeconcert.awesomeconcert.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.ItemRowExploreCoverflowBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ExploreRowCoverflowItemViewModel;

/**
 * Projet IHM - AwesomeConcert
 *
 * Cette classe est responsable de faire la vue pour chacun des items du dateset.
 *
 * Seeheim : Partie traitement des données
 *
 * Auteur : Guillaume BOULIC
 * Auteur : Rémi BARBASTE
 *
 * Date : 23/11/2016
 */

public class CoverflowAdapter extends RecyclerView.Adapter<CoverflowAdapter.CoverViewHolder> {
    private static final String TAG = "CoverflowAdapter";
    private List<Concert> mConcerts;
    private OnItemClickedListener mListener;

    public CoverflowAdapter() {
        mConcerts = new ArrayList<>();
    }

    public CoverflowAdapter(CoverflowItem item) {
        this.mConcerts = item.getmConcerts();
        this.mListener = item.getmListener();
        Log.e(TAG, "Created for "+mConcerts.size()+" items");
    }

    @Override
    public CoverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_explore_coverflow, parent, false);
        Log.e(TAG, "VH created");
        return new CoverViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CoverViewHolder holder, int position) {
        holder.bind(this.mConcerts.get(position), this.mListener);
        Log.e(TAG, this.mConcerts.get(position).getConcertName()+" bound");
    }

    @Override
    public int getItemCount() {
        return this.mConcerts.size();
    }

    public void setCoverflowItem(CoverflowItem item) {
        Log.d(TAG, "CoverflowAdapter populated");
        mConcerts.clear();
        mConcerts.addAll(item.getmConcerts());
        mListener = item.getmListener();
        notifyDataSetChanged();
    }

    class CoverViewHolder extends RecyclerView.ViewHolder {
        private ItemRowExploreCoverflowBinding mBinding;

        CoverViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        void bind(Concert concert, OnItemClickedListener listener) {
            mBinding.setViewModel(new ExploreRowCoverflowItemViewModel(concert, listener));
            mBinding.executePendingBindings();
        }
    }
}
