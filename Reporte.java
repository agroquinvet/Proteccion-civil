package com.example.reporteproteccioncivil;

public class Reporte {
    private  String foto; // Recurso de imagen para la foto
    private String tipoIncidente;
    private String descripcion;
    private String ubicacion;

    public Reporte( String foto, String tipoIncidente, String descripcion, String ubicacion) {
        this.foto = foto;
        this.tipoIncidente = tipoIncidente;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public  String getFoto() {
        return foto;
    }

    public String getTipoIncidente() {
        return tipoIncidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
