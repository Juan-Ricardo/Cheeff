package com.pe.cheeff.home.model;

public class DetailResponse {
    private String _id;
    private String plato_id;
    private String nombre;
    private double precio;
    private int cantidad;

    public DetailResponse() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPlato_id() {
        return plato_id;
    }

    public void setPlato_id(String plato_id) {
        this.plato_id = plato_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
