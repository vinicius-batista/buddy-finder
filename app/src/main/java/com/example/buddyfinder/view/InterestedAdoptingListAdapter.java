package com.example.buddyfinder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buddyfinder.R;
import com.example.buddyfinder.model.Supporter;

import java.util.ArrayList;

public class InterestedAdoptingListAdapter extends RecyclerView.Adapter<InterestedAdoptingListViewHolder> {
    private ArrayList<Supporter> interestedAdopting;
    private ApproveListener approveListener;

    public InterestedAdoptingListAdapter(ArrayList<Supporter> interestedAdopting, ApproveListener approveListener) {
        this.interestedAdopting = interestedAdopting;
        this.approveListener = approveListener;
    }

    @NonNull
    @Override
    public InterestedAdoptingListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_interested_adopting_list, viewGroup, false);
        return new InterestedAdoptingListViewHolder(view, this.approveListener);
    }

    @Override
    public void onBindViewHolder(@NonNull InterestedAdoptingListViewHolder interestedAdoptingListViewHolder, int i) {
        interestedAdoptingListViewHolder.bind(this.interestedAdopting.get(i));
    }

    @Override
    public int getItemCount() {
        return this.interestedAdopting.size();
    }

    public interface ApproveListener {
        void onClickApprove(Supporter supporter);
    }
}
