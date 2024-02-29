/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springtodocode.proyectofinalSP.service;

import com.springtodocode.proyectofinalSP.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Pablo Gimenez
 */
public interface IClienteService {
    
   
    
    public void createCliente(Cliente cli);
        
    public void deleteCliente(Long id_cliente);
    
    public Cliente getCliente(Long id);
    
    public List<Cliente> getClientes();
    
    public void editCliente(Cliente cli);
  
    
    
}
