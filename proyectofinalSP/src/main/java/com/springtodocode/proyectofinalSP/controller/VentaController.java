/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springtodocode.proyectofinalSP.controller;

import com.springtodocode.proyectofinalSP.dto.VentaMayorDTO;
import com.springtodocode.proyectofinalSP.model.Cliente;
import com.springtodocode.proyectofinalSP.model.Producto;
import com.springtodocode.proyectofinalSP.model.Venta;
import com.springtodocode.proyectofinalSP.service.IProductoService;
import com.springtodocode.proyectofinalSP.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaS;
    
    /*
    Poder realizar un CRUD completo de ventas
a. Métodos HTTP: GET, POST, DELETE, PUT
b. Endpoints:
Creación: localhost:8080/ventas/crear
Lista completa de ventas realizadas: localhost:8080/ventas
Traer una venta en particular: localhost:8080/ventas/{codigo_venta}
Eliminación: localhost:8080/clientes/eliminar/{codigo_venta}
Edición: localhost:8080/clientes/editar/{codigo_venta}
    */
    
    @PostMapping("/ventas/crear")
    public String createVenta(@RequestBody Venta venta) {
           
        
        ventaS.crearVenta(venta);
        
        
        return "La Venta se genero exitosamente";
    }

    
    @GetMapping("/ventas")
    public List<Venta> getAllVentas(){
    
        List<Venta> ventasall=new ArrayList<Venta>();
        
        return ventasall=ventaS.getTotalVentas();
            
    }
    
    @GetMapping("/ventas/{codigo_venta}")
    public Venta getOneVenta(@PathVariable Long codigo_venta){
    
        Venta unaVenta=ventaS.getVenta(codigo_venta);
       
    return unaVenta;
    
    }
    
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
    
     ventaS.deleteVenta(codigo_venta);
    
    return "La venta se ha eliminado correctamente";
    
    }
    
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta(@RequestBody Venta venta,@PathVariable Long codigo_venta){
       
        
        Venta ventaMod=ventaS.getVenta(codigo_venta);

        ventaS.editVenta(venta,codigo_venta);
        
        return ventaMod;
        
    
    }
            
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosVenta(@PathVariable Long codigo_venta){
        
      Venta venta=ventaS.getVenta(codigo_venta);
      
      return venta.getListaProductos();
    
    
    }

    @GetMapping("/ventas/fecha/{fecha_venta}")
    public String getVentaFecha(@PathVariable LocalDate fecha_venta){

        double total=0;
        int cantVentas=0;

        List<Venta> Ventas=ventaS.getTotalVentas();

        for (Venta venta:Ventas){

            if(venta.getFecha_venta().equals(fecha_venta)){
                cantVentas=cantVentas+1;
                total=total+venta.getTotal();
            }

        }

        return "El monto total en la fecha "+fecha_venta+ " es de :" + total +" y el total de la cantidad de ventas : "+cantVentas;


    }

    @GetMapping("ventas/venta_mayor")
    public VentaMayorDTO getVentaMayor(){


        return  ventaS.getMayorVenta();


    }
    
    
}
