package com.pe.cheeff.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class DataOrderResponse {
    private String fechaRegistro;
    private String _id;
    private CustomerResponse cliente_id;
    private double total;
    private List<DetailResponse> detalle;
    private int __v;

    public DataOrderResponse() {

    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public CustomerResponse getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(CustomerResponse cliente_id) {
        this.cliente_id = cliente_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetailResponse> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetailResponse> detalle) {
        this.detalle = detalle;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
