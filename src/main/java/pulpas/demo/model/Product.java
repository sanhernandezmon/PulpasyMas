package pulpas.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private String id;
    private String tipo;
    private String especificacion;
    private int presentacion;
    private double valorUnitario;
    private int disponibilidad;

    public Product() {

    }

    public Product(@JsonProperty String tipo,
                   @JsonProperty String especificacion,
                   @JsonProperty int presentacion,
                   @JsonProperty double valorUnitario) {
        this.tipo = tipo;
        this.especificacion = especificacion;
        this.presentacion = presentacion;
        this.valorUnitario = valorUnitario;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setPresentacion(int presentacion) {
        this.presentacion = presentacion;
    }

    public int getPresentacion() {
        return presentacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponivilidad) {
        this.disponibilidad = disponivilidad;
    }


}
