package com.pe.cheeff.home.adapter;

import android.os.Parcel;
import android.os.Parcelable;

public class ChildData implements Parcelable {
    private String _id;
    private String plato_id;
    private String nombre;
    private double precio;
    private int cantidad;

    public ChildData() {
    }

    protected ChildData(Parcel in) {
        _id = in.readString();
        plato_id = in.readString();
        nombre = in.readString();
        precio = in.readDouble();
        cantidad = in.readInt();
    }

    public static final Creator<ChildData> CREATOR = new Creator<ChildData>() {
        @Override
        public ChildData createFromParcel(Parcel in) {
            return new ChildData(in);
        }

        @Override
        public ChildData[] newArray(int size) {
            return new ChildData[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(plato_id);
        dest.writeString(nombre);
        dest.writeDouble(precio);
        dest.writeInt(cantidad);
    }
}
