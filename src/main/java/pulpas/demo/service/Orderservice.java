package pulpas.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pulpas.demo.dao.ClienteDAO;
import pulpas.demo.dao.OrderDAO;
import pulpas.demo.dao.ProductDAO;
import pulpas.demo.model.Order;
import pulpas.demo.model.Product;

import java.util.ArrayList;
import java.util.Date;

@Service
public class Orderservice {

    private final OrderDAO orderDAO;
    private final ClienteDAO clienteDAO;
    private final ProductDAO productDAO;


    public Orderservice(@Qualifier("OrdenFirestore") OrderDAO orderDAO, ClienteDAO clienteDAO, ProductDAO productDAO) {
        this.orderDAO = orderDAO;
        this.clienteDAO = clienteDAO;
        this.productDAO = productDAO;
    }

    public Order addOrder(Order order) {
        ArrayList<String> products = order.getProducts();
        double ValorMinimo = 0;
        for (String product: products) {
            Product p = productDAO.getProduct(product);
            productDAO.quitarProducto(p.getId());
            ValorMinimo = ValorMinimo + p.getValorUnitario();
        }
        order.setPrecioMinimo(ValorMinimo);
        Order ret = orderDAO.createOrder(order);
        clienteDAO.agregarOrden(order.getClienteID());
        return ret;
    }

    public ArrayList<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public Order getOrder(String id) {
        return orderDAO.getOrder(id);
    }

    public boolean deleteOrder(String id) {
        clienteDAO.eliminarOrden(orderDAO.getOrder(id).getClienteID());
        return orderDAO.deleteOrder(id);
    }

    public Date entregarOrden(String id){
        return orderDAO.entregarOrden(id);
    }

    public  Order actualizarProductosOrdenados(String id, ArrayList<String> productos){
        return orderDAO.actualizarProductosOrdenados(id,productos);
    }
}
