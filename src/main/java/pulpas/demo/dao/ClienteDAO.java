package pulpas.demo.dao;


import pulpas.demo.model.Cliente;
import java.util.ArrayList;

public interface ClienteDAO {

    Cliente createCliente(Cliente c);

    Cliente getCliente(String name);

    boolean deleteCliente(String name);

    ArrayList<Cliente> getAllClientes();

    int agregarOrden(String name);

    int eliminarOrden(String name);

}