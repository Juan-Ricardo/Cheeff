package com.pe.cheeff.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pe.cheeff.R;
import com.pe.cheeff.home.model.DetailResponse;
import com.pe.cheeff.home.viewholder.DetailViewHolder;
import com.pe.cheeff.home.viewholder.PurchaseOrderViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class PurchaseOrderRecycler extends ExpandableRecyclerViewAdapter<PurchaseOrderViewHolder, DetailViewHolder> {

    private Activity activity;

    public PurchaseOrderRecycler(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public PurchaseOrderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.purchase_order_card_view, parent, false);
        return new PurchaseOrderViewHolder(view);
    }

    @Override
    public DetailViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.detail_card_view, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(DetailViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final ChildData childData = ((ParentData) group).getItems().get(childIndex);
        holder.setChildText(childData.getNombre());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity.getBaseContext(), "" + childData.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBindGroupViewHolder(PurchaseOrderViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);
    }
}
