package pulpas.demo.firestoredao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;
import pulpas.demo.dao.ProductDAO;
import pulpas.demo.model.ID;
import pulpas.demo.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Repository("ProductFirestore")
public class ProductFirestoreDAO implements ProductDAO {

    public ID setOrderId() {
        ID ret = new ID();
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference ref = db.collection("id").document("idproduct");
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot document;
        try {
            document = future.get();
            if (document.exists()) {
                ret = document.toObject(ID.class);
            } else {
                System.out.println("No such document for product ID");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(ret).setId(ret.getId() + 1);
        ref.set(ret);
        return ret;
    }

    @Override
    public Product createProduct(Product p) {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference ref = db.collection("product");

        try {
            p.setId(setOrderId().toString());
            ref.document(p.getId()).set(p).get();
            return p;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product getProduct(String id) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference ref = db.collection("product").document(id);
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot document;
        Product ret = null;
        try {
            document = future.get();
            if (document.exists()) {
                ret = document.toObject(Product.class);
            } else {
                System.out.println("No such document for this product!");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean deleteProduct(String id) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("product").document(id).delete();
        return true;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference orderRef = db.collection("product");
        ApiFuture<QuerySnapshot> docs = orderRef.get();
        List<QueryDocumentSnapshot> docList;
        try {
            docList = docs.get().getDocuments();
            for (QueryDocumentSnapshot a : docList) {
                products.add(a.toObject(Product.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return products;    }

    @Override
    public int agregarProducto(String id) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference ref = db.collection("product").document(id);
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot document;
        Product ret = null;
        try {
            document = future.get();
            if (document.exists()) {
                ret = document.toObject(Product.class);
                ret.setDisponivilidad(ret.getDisponibilidad()+1);
                ref.set(ret);
            } else {
                System.out.println("No such document for this product!");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return ret.getDisponibilidad();
    }

    @Override
    public int quitarProducto(String id) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference ref = db.collection("product").document(id);
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot document;
        Product ret = null;
        try {
            document = future.get();
            if (document.exists()) {
                ret = document.toObject(Product.class);
                ret.setDisponivilidad(ret.getDisponibilidad()-1);
                ref.set(ret);
            } else {
                System.out.println("No such document for this product!");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return ret.getDisponibilidad();
    }
}
