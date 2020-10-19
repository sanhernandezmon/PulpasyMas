package pulpas.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private String id;
    private String clienteID;
    private Date fechaPedido;
    private Date fechaEntrega;
    private ArrayList <String> products;
    private Double precioMinimo;


    public Order() {
    }

    public Order(@JsonProperty("cliente") String clienteID,
                 @JsonProperty("fechapedido") Date fechaPedido,
                 @JsonProperty("fechaentrega") Date fechaEntrega,
                 @JsonProperty("productos") ArrayList<String> products
                 ) {

        this.clienteID = clienteID;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.products = products;
        this.precioMinimo = 0.0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", clienteID='" + clienteID + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", fechaEntrega=" + fechaEntrega +
                ", products=" + products +
                ", precioMinimo=" + precioMinimo +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }

    public Double getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(Double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }
}
