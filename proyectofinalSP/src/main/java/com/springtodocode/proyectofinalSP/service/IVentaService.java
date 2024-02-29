/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springtodocode.proyectofinalSP.service;

import com.springtodocode.proyectofinalSP.dto.VentaMayorDTO;
import com.springtodocode.proyectofinalSP.model.Cliente;
import com.springtodocode.proyectofinalSP.model.Producto;
import com.springtodocode.proyectofinalSP.model.Venta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Gimenez
 */
public interface IVentaService {
    
    public void crearVenta(Venta venta);
    
    
    public Venta getVenta(Long id);
    
    
    public List<Venta> getTotalVentas();
    
    public void deleteVenta(Long id);
    
    public void editVenta(Venta venta,Long id);

    public VentaMayorDTO getMayorVenta();

}
