package pulpas.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ListaProductos {
    private ArrayList<String> productos;

    public  ListaProductos(){

    }
    public ListaProductos(@JsonProperty("productos") ArrayList<String> productos) {
        this.productos = productos;
    }

    public ArrayList<String> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<String> productos) {
        this.productos = productos;
    }
}
