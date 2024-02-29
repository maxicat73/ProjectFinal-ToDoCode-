/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springtodocode.proyectofinalSP.repository;

import com.springtodocode.proyectofinalSP.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pablo Gimenez
 */
@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long>{
    
}
