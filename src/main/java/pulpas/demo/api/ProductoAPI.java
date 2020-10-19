package pulpas.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pulpas.demo.model.Product;
import pulpas.demo.service.ProductService;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RequestMapping("/producto")
@RestController
public class ProductoAPI {

    private final ProductService productService;

    @Autowired
    public ProductoAPI(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product postProduct(@RequestBody Product p) {
        return productService.addProduct(p);
    }

    @GetMapping
    public ArrayList<Product> getAllProducts (){
        return productService.getAllProduct();
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @PutMapping("/agregar/{id}")
    public int agregarProducto(@PathVariable String id){ return productService.agregarProduct(id);}


    @PutMapping("/quitar/{id}")
    public int quitarProducto(@PathVariable String id){ return productService.quitarProducto(id);}
}
