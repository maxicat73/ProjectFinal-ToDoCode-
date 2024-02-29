/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springtodocode.proyectofinalSP.controller;

import com.springtodocode.proyectofinalSP.model.Cliente;
import com.springtodocode.proyectofinalSP.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
Realizar un CRUD completo de clientes
a. Métodos HTTP: GET, POST, DELETE, PUT
b. Endpoints:

 */
@RestController
public class ClienteController {

@Autowired
private ClienteService cliente;


//creación: localhost:8080/clientes/crear
@PostMapping("/clientes/crear")
public String crearCliente(@RequestBody Cliente cli){

    cliente.createCliente(cli);

return "El cliente se ha creado correctamente";

}
//Lista completa de clientes: localhost:8080/clientes
@GetMapping("/clientes")
@ResponseBody
public List<Cliente> traerClientes(){

    List<Cliente> clientes=new ArrayList<Cliente>();
    
    return clientes=cliente.getClientes();

}


//Traer un cliente en particular: localhost:8080/clientes/{id_cliente}
@GetMapping("/clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente){
    
    return cliente.getCliente(id_cliente);
    
    }
    
    
    //Eliminación: localhost:8080/clientes/eliminar/{id_cliente}
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente)
    {
        cliente.deleteCliente(id_cliente);
        
        return "El cliente se ha borrado exitosamente";
    }


    
    //Edición: localhost:8080/clientes/editar/{id_cliente}
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente modificarCliente(@PathVariable Long id_cliente,@RequestBody Cliente cliMod){
    
        Cliente cli=cliente.getCliente(id_cliente);
        cli=cliMod;
       cliente.editCliente(cli);
       
       return cli;
    
    }
    
    
}
