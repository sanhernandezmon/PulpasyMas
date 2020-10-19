package pulpas.demo.firestoredao;

import pulpas.demo.dao.ClienteDAO;
import pulpas.demo.model.Cliente;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ExecutionException;



@Repository("ClienteFirestore")
public class ClienteFirestoreDAO implements ClienteDAO {

    @Override
    public Cliente createCliente(Cliente c) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("client").document(c.getName()).set(c);
        return c;
    }

    @Override
    public Cliente getCliente(String name) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference ref = db.collection("client").document(name);
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot document;
        Cliente ret = null;
        try {
            document = future.get();
            if (document.exists()) {
                ret = document.toObject(Cliente.class);
            } else {
                System.out.println("No such document!");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public boolean deleteCliente(String name) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("client").document(name).delete();
        return true;
    }

    @Override
    public ArrayList<Cliente> getAllClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference orderRef = db.collection("client");
        ApiFuture<QuerySnapshot> docs = orderRef.get();
        List<QueryDocumentSnapshot> docList;
        try {
            docList = docs.get().getDocuments();
            for (QueryDocumentSnapshot a : docList) {
                clientes.add(a.toObject(Cliente.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
