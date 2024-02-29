package com.springtodocode.proyectofinalSP.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VentaMayorDTO {

    private Long codigo_venta;
    private Double total;
    private int totalprod;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentaMayorDTO() {
    }

    public VentaMayorDTO(Long codigo_venta, Double total, int totalprod, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.totalprod = totalprod;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }


}
