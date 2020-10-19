package pulpas.demo.service;


import pulpas.demo.dao.*;
import pulpas.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ClienteService {

    private final ClienteDAO clienteDAO;


    @Autowired
    public ClienteService(@Qualifier("ClienteFirestore") ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public Cliente addCliente(Cliente cliente) {
        for (Cliente u : clienteDAO.getAllClientes()) {
            if (u.getEmail().equals(cliente.getName())) {
                System.out.println("ya existe un usuario registrado con este correo, por favor intenta te nuevo");
                return null;
            }
        }
        return clienteDAO.createCliente(cliente);
    }


    public ArrayList<Cliente> getAllClient() {
        return clienteDAO.getAllClientes();
    }

    public Cliente getClient(String name) {
        return clienteDAO.getCliente(name);
    }


    public boolean deleteClient(String name) {
        return  clienteDAO.deleteCliente(name);
    }
}