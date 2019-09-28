package com.pe.cheeff.home.model;

import java.util.List;

public class PurchaseOrderResponse {
    private List<DataOrderResponse> data;

    public PurchaseOrderResponse() {

    }

    public List<DataOrderResponse> getData() {
        return data;
    }

    public void setData(List<DataOrderResponse> data) {
        this.data = data;
    }
}
