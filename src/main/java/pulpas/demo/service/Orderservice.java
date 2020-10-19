package pulpas.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pulpas.demo.dao.OrderDAO;
import pulpas.demo.model.Order;

import java.util.ArrayList;

@Service
public class Orderservice {

    private final OrderDAO orderDAO;


    public Orderservice(@Qualifier("OrdenFirestore")OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order addOrder(Order order) { return orderDAO.createOrder(order); }

    public ArrayList<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public Order getOrder(String id) {
        return orderDAO.getOrder(id);
    }

    public boolean deleteOrder(String id) {
        return  orderDAO.deleteOrder(id);
    }
}
