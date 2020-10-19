package pulpas.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private String clienteID;
    private Date fechaPedido;
    private Date fechaEntrega;
    private ArrayList <Product> products;
    private String factura;
    private Double precioMinimo;


    public Order() {
    }

    public Order(@JsonProperty("cliente") String clienteID,
                 @JsonProperty("fechapedido") Date fechaPedido,
                 @JsonProperty("fechaentrega") Date fechaEntrega,
                 @JsonProperty("productos") ArrayList<Product> products
                 ) {

        this.clienteID = clienteID;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.products = products;
        this.factura = null;
        this.precioMinimo = 0.0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "clienteID='" + clienteID + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", fechaEntrega=" + fechaEntrega +
                ", products=" + products +
                ", factura='" + factura + '\'' +
                ", precioMinimo=" + precioMinimo +
                '}';
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Double getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(Double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }
}
