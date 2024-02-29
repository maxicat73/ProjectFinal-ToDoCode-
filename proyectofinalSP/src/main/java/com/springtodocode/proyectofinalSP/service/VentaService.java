/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springtodocode.proyectofinalSP.service;

import com.springtodocode.proyectofinalSP.dto.VentaMayorDTO;

import com.springtodocode.proyectofinalSP.model.Producto;
import com.springtodocode.proyectofinalSP.model.Venta;

import com.springtodocode.proyectofinalSP.repository.IVentaRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Pablo Gimenez
 */
@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoService produServi;

    @Override
    public void crearVenta(Venta venta) {

        List<Producto> prod = venta.getListaProductos();
        double sumaTotal = 0;

        for (Producto producto : prod) {

            Producto productoActual = produServi.getProducto(producto.getCodigo_producto());
            sumaTotal = sumaTotal+  productoActual.getCosto();

        }
        
        venta.setTotal(sumaTotal);
        
        ventaRepo.save(venta);

    }


    @Override
    public Venta getVenta(Long id) {
       
        return ventaRepo.findById(id).orElse(null);
       
    }

    @Override
    public List<Venta> getTotalVentas() {
       return ventaRepo.findAll();
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void editVenta(Venta venta,Long id) {
        
        Venta ventaModif=this.getVenta(id);
        ventaModif.setFecha_venta(venta.getFecha_venta());
//        ventaModif.setListaProductos(venta.getListaProductos());
        ventaModif.setUnCliente(venta.getUnCliente());
        
      ventaRepo.save(ventaModif);
       
    }


    public VentaMayorDTO getMayorVenta(){

        List<Venta> allVentas=this.getTotalVentas();
        VentaMayorDTO ventaMayor=new VentaMayorDTO();

        double montototal=0;
        int cantidad_productos=0;

        for(Venta venta:allVentas){
            if(venta.getTotal()>montototal){
               montototal=venta.getTotal();
               cantidad_productos=venta.getListaProductos().size();
               ventaMayor.setCodigo_venta(venta.getCodigo_venta());
               ventaMayor.setTotal(montototal);
               ventaMayor.setTotalprod(cantidad_productos);
               ventaMayor.setNombre_cliente(venta.getUnCliente().getNombre());
               ventaMayor.setApellido_cliente(venta.getUnCliente().getApellido());

            }
        }

        return ventaMayor;

    }

 
}
