package pulpas.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pulpas.demo.dao.ProductDAO;
import pulpas.demo.model.Product;

import java.util.ArrayList;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductService(@Qualifier("ProductFirestore")ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product addProduct(Product product) {
        for (Product p : productDAO.getAllProducts()) {
            if ((p.getPresentacion()==product.getPresentacion())&&(p.getEspecificacion().equals(product.getEspecificacion()))) {
                System.out.println("ya existe un producto con los datos especificados, pruebe actualizar el precio");
                return null;
            }
        }
        return productDAO.createProduct(product);
    }


    public ArrayList<Product> getAllProduct() {
        return productDAO.getAllProducts();
    }

    public Product getProduct(String id) {
        return productDAO.getProduct(id);
    }

    public boolean deleteProduct(String id) {
        return  productDAO.deleteProduct(id);
    }

    public int agregarProduct(String id){
        return productDAO.agregarProducto(id);
    }

    public int quitarProducto(String id){
        return productDAO.quitarProducto(id);
    }
}
