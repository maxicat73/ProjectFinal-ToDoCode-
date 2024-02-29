/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springtodocode.proyectofinalSP.service;

import com.springtodocode.proyectofinalSP.model.Producto;

import java.util.List;

/**
 *
 * @author Pablo Gimenez
 */
public interface IProductoService {
    
    public void createProducto(Producto prod);
    
    public List<Producto> getTotalProductos();
    
    public Producto getProducto(Long id);
    
    public void deleteProducto(Long id);
    
    public void modificarProducto(Producto ventaMod);
    
    public List<Producto> getPSinStock();
    
}
