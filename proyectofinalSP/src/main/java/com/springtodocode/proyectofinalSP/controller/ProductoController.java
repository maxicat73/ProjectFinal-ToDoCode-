/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springtodocode.proyectofinalSP.controller;

import com.springtodocode.proyectofinalSP.model.Producto;
import com.springtodocode.proyectofinalSP.service.IProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pablo Gimenez
 */
@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService prod;
    /*
    Poder realizar un CRUD completo de productos
a. Métodos HTTP: GET, POST, DELETE, PUT
b. Endpoints:
Creación: localhost:8080/productos/crear
Lista completa de productos: localhost:8080/productos
Traer un producto en particular: localhost:8080/productos/{codigo_producto}
Eliminación: localhost:8080/productos/eliminar/{codigo_producto}
Edición: localhost:8080/productos/editar/{codigo_producto}
    */
    
    
    //localhost:8080/productos/crear
    
    @PostMapping("/productos/crear")
    public String createProducto(@RequestBody Producto produ){
    
        prod.createProducto(produ);
    
        return "El producto ha sido creado correctamente";
        
    }
    
    //localhost:8080/productos
    @GetMapping("/productos")
    public List<Producto> getProductos(){
    
        List<Producto> productos=new ArrayList<Producto>();
    
    return productos=prod.getTotalProductos();
        
    
    }
    
   // localhost:8080/productos/{codigo_producto}
    @GetMapping("/productos/{codigo_producto}")
    public Producto getUnProducto(@PathVariable Long codigo_producto){
    
    return prod.getProducto(codigo_producto);
    
    }
    
    
    //localhost:8080/productos/eliminar/{codigo_producto}
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
    
        prod.deleteProducto(codigo_producto);
        
        return "El producto ha sido eliminado correctamente";
    
    }
   // localhost:8080/productos/editar/{codigo_producto}
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProd(@PathVariable Long codigo_producto,@RequestBody Producto prodMod){
    
        Producto produc=prod.getProducto(codigo_producto);
        produc=prodMod;
        prod.modificarProducto(produc);
        
        return produc;
        
    }
    
    @GetMapping("/productos/sinstock")
public List<Producto> getProdSinStock(){

    return prod.getPSinStock();

}
    

    
}
