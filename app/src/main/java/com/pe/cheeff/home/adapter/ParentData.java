package com.pe.cheeff.home.adapter;

import android.annotation.SuppressLint;

import com.pe.cheeff.home.model.DataOrderResponse;
import com.pe.cheeff.home.model.DetailResponse;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

@SuppressLint("ParcelCreator")
public class ParentData extends ExpandableGroup<ChildData> {

    public ParentData(String title, List<ChildData> items) {
        super(title, items);
    }
}
