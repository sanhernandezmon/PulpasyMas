package pulpas.demo.firestoredao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;
import pulpas.demo.dao.OrderDAO;
import pulpas.demo.model.ID;
import pulpas.demo.model.Order;
import pulpas.demo.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Repository("OrdenFirestore")
public class OrderFirestoreDAO implements OrderDAO {

    public ID setOrderId() {
        ID ret = new ID();
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference ref = db.collection("id").document("idorder");
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot document;
        try {
            document = future.get();
            if (document.exists()) {
                ret = document.toObject(ID.class);
            } else {
                System.out.println("No such document for order ID");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(ret).setId(ret.getId() + 1);
        ref.set(ret);
        return ret;
    }

    public double calcularValorMinimo(Order o){
        ArrayList<Product> products = o.getProducts();
        double ret = 0.0;
        for (Product product: products) {
                ret = ret + product.getValorUnitario();
        }
        return ret;
    }

    @Override
    public Order createOrder(Order o) {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference ref = db.collection("order");
        try {
            o.setPrecioMinimo(calcularValorMinimo(o));
            o.setId(setOrderId().toString());
            ref.document(o.getId()).set(o).get();
            return o;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Order getOrder(String id) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference ref = db.collection("order").document(id);
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot document;
        Order ret = null;
        try {
            document = future.get();
            if (document.exists()) {
                ret = document.toObject(Order.class);
            } else {
                System.out.println("No such document for this order!");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean deleteOrder(String id) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("order").document(id).delete();
        return true;
    }

    @Override
    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference orderRef = db.collection("product");
        ApiFuture<QuerySnapshot> docs = orderRef.get();
        List<QueryDocumentSnapshot> docList;
        try {
            docList = docs.get().getDocuments();
            for (QueryDocumentSnapshot a : docList) {
                orders.add(a.toObject(Order.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
