package pulpas.demo.api;

import pulpas.demo.model.Cliente;
import pulpas.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = "*")
@RequestMapping("/cliente")
@RestController
public class ClienteAPI {

    private final ClienteService clienteService;

    @Autowired
    public ClienteAPI(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente postCliente(@RequestBody Cliente c) {
        return clienteService.addCliente(c);
    }

    @GetMapping
    public ArrayList<Cliente> getAllClientes (){
        return clienteService.getAllClient();
    }

    @DeleteMapping("/{name}")
    public boolean deleteCliente(@PathVariable String name) {
        return clienteService.deleteClient(name);
    }

    @GetMapping("/{name}")
    public Cliente getCliente(@PathVariable String name){
        return clienteService.getClient(name);
    }

}
