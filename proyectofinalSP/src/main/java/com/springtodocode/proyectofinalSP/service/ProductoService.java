/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springtodocode.proyectofinalSP.service;

import com.springtodocode.proyectofinalSP.model.Producto;
import com.springtodocode.proyectofinalSP.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pablo Gimenez
 */
@Service
public class ProductoService implements IProductoService{
    
    @Autowired
   private IProductoRepository productoRepo;
 

    @Override
    public void createProducto(Producto prod) {
    
        productoRepo.save(prod);
        
       
    }

    @Override
    public List<Producto> getTotalProductos() {
        
        return productoRepo.findAll();
        
    }

    @Override
    public Producto getProducto(Long id) {
       return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(Long id) {
       productoRepo.deleteById(id);
    }

    @Override
    public void modificarProducto(Producto ventaMod) {
       productoRepo.save(ventaMod);
    }

    @Override
    public List<Producto> getPSinStock() {

        List<Producto> allProducts = productoRepo.findAll();
        List<Producto> prodSinStock = new ArrayList<Producto>();

        for (Producto product : allProducts) {
            if (product.getCantidad_disponible() < 5) {
                prodSinStock.add(product);
            }
        }
      return prodSinStock ;
    }

  

}
