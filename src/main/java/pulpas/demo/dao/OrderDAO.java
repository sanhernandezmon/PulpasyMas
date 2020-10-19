package pulpas.demo.dao;

import pulpas.demo.model.Order;
import pulpas.demo.model.Product;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDAO {
    Order createOrder(Order o);

    Order getOrder(String id);

    boolean deleteOrder(String id);

    ArrayList<Order> getAllOrders();

    Date entregarOrden(String id);

    Order actualizarProductosOrdenados(String id, ArrayList<String> productos);
}
