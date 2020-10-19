package pulpas.demo.dao;

import pulpas.demo.model.Cliente;
import pulpas.demo.model.Product;

import java.util.ArrayList;

public interface ProductDAO {
    Product createProduct(Product p);

    Product getProduct(String id);

    boolean deleteProduct(String id);

    ArrayList<Product> getAllProducts();

    int agregarProducto(String id);

    int quitarProducto(String id);

}
