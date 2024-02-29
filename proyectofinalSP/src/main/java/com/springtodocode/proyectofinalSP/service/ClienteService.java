/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springtodocode.proyectofinalSP.service;

import com.springtodocode.proyectofinalSP.model.Cliente;
import com.springtodocode.proyectofinalSP.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pablo Gimenez
 */
@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void createCliente(Cliente cli) {
      
        clienteRepo.save(cli);
        
    }

    @Override
    public void deleteCliente(Long id_cliente) {
       clienteRepo.deleteById(id_cliente);
       
    }

    @Override
    public Cliente getCliente(Long id) {
     
       return clienteRepo.findById(id).orElse(null);
        
    }

    @Override
    public List<Cliente> getClientes() {
        
        return clienteRepo.findAll();
    }

    @Override
    public void editCliente(Cliente cli) {
   
        clienteRepo.save(cli);
        
    }
    
}
