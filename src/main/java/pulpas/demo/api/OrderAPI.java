package pulpas.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pulpas.demo.model.Order;
import pulpas.demo.service.Orderservice;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Date;

@CrossOrigin(origins = "*")
@RequestMapping("/orden")
@RestController
public class OrderAPI {
    private final Orderservice orderservice;

    @Autowired
    public OrderAPI(Orderservice orderservice) {
        this.orderservice = orderservice;
    }

    @PostMapping
    public Order postOrder(@RequestBody Order o) {
        return orderservice.addOrder(o);
    }

    @GetMapping
    public ArrayList<Order> getAllOrder (){
        return orderservice.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public boolean deleteCliente(@PathVariable String id) {
        return orderservice.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public Order getCliente(@PathVariable String id){
        return orderservice.getOrder(id);
    }

    @PutMapping("entregar/{id}")
    public Date entregarOrden(@PathVariable String id){return orderservice.entregarOrden(id); }

    @PutMapping("pedidos/{id}")
    public Order actualizarProductosOrdenados(@PathVariable String id , @RequestBody ArrayList<String> productos){
        return orderservice.actualizarProductosOrdenados(id,productos); }


}
