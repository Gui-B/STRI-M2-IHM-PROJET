package fr.stri.ihm.awesomeconcert.awesomeconcert.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Iterator;
import java.util.List;

import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.RowExploreConcertBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.databinding.RowExploreCoverflowBinding;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ExploreRowConcertViewModel;
import fr.stri.ihm.awesomeconcert.awesomeconcert.viewmodel.ExploreRowCoverflowViewModel;

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
 * Date : 22/11/2016
 */
public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.StrategyViewHolder> {
    private static final String TAG = "ExploreAdapter";
    private List<StrategyItem> items;

    public ExploreAdapter(List<StrategyItem> items) {
        this.items = items;
    }

    @Override
    public StrategyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case StrategyItem.TYPE_COVERFLOW:
                return new CoverflowViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_explore_coverflow, parent, false));
            case StrategyItem.TYPE_CONCERT:
                return new ConcertViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_explore_concert, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(StrategyViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    /*public void refineArtist(String hint) {
        Iterator<StrategyItem> iter = items.iterator();
        int i = 0;
        while(iter.hasNext()) {
            StrategyItem item = iter.next();
            if(item.getType() == StrategyItem.TYPE_CONCERT && ((ConcertItem) item).getConcert().getConcertArtist().contains(hint)) {
                iter.remove();
                notifyItemRemoved(i);
            }
        }
    }*/

    private void addItem(StrategyItem item) {
        if(getItemIndex(item) >= 0) {
            items.add(item);
            notifyItemInserted(getItemCount() - 1);
        }
    }

    private void removeItem(StrategyItem item) {
        int i = getItemIndex(item);
        if(i >= 0) {
            items.remove(i);
            notifyItemRemoved(i);
        }
    }

    private int getItemIndex(StrategyItem item) {
        return items.indexOf(item);
    }

    abstract class StrategyViewHolder<I extends StrategyItem> extends RecyclerView.ViewHolder {

        StrategyViewHolder(View itemView) {
            super(itemView);
        }

        abstract void bind(I item);
    }

    private class ConcertViewHolder extends ExploreAdapter.StrategyViewHolder<ConcertItem> {
        private RowExploreConcertBinding mBinding;

        ConcertViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        @Override
        void bind(ConcertItem item) {
            mBinding.setViewModel(new ExploreRowConcertViewModel(item));
            mBinding.executePendingBindings();
        }
    }

    private class CoverflowViewHolder extends ExploreAdapter.StrategyViewHolder<CoverflowItem> {
        private RowExploreCoverflowBinding mBinding;
        private CoverflowAdapter mAdapter;

        CoverflowViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
            mBinding.coverflowRecycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            mAdapter = new CoverflowAdapter();
            mBinding.coverflowRecycler.setAdapter(mAdapter);
        }

        @Override
        void bind(CoverflowItem item) {
            mBinding.setViewModel(new ExploreRowCoverflowViewModel(item, mAdapter));
            mBinding.executePendingBindings();
        }
    }
}
