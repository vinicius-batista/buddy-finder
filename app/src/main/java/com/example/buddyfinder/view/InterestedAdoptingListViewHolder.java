package com.example.buddyfinder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.buddyfinder.R;
import com.example.buddyfinder.model.Supporter;

public class InterestedAdoptingListViewHolder extends RecyclerView.ViewHolder implements Button.OnClickListener {
    private TextView txtName;
    private TextView txtPhone;
    private Supporter supporter;
    private InterestedAdoptingListAdapter.ApproveListener listener;

    public InterestedAdoptingListViewHolder(@NonNull View itemView, InterestedAdoptingListAdapter.ApproveListener listener) {
        super(itemView);
        this.txtName = itemView.findViewById(R.id.txtName);
        this.txtPhone = itemView.findViewById(R.id.txtPhone);
        this.listener = listener;

        Button btnApprove = itemView.findViewById(R.id.btnApprove);
        btnApprove.setOnClickListener(this);
    }

    public void bind(Supporter supporter) {
        this.supporter = supporter;
        this.txtName.setText(supporter.getName());
        this.txtPhone.setText(supporter.getPhone());
    }

    @Override
    public void onClick(View v) {
        this.listener.onClickApprove(supporter);
    }
}
