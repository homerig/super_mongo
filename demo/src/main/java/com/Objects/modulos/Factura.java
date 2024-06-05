package com.Objects.modulos;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Factura")

public class Factura {
    @Id
    private String id;
    private int numeroFactura;
    private Carrito pedido;
    private Date fechaEmision;
    private String formaPago;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public int getNumeroFactura(){
        return numeroFactura;
    }
    public void setNumeroFactura(int numeroFactura){
        this.numeroFactura = numeroFactura;
    }
    public Carrito getPedido(){
        return pedido;
    }
    public void setPedido(Carrito pedido){
        this.pedido = pedido;
    }
    public Date getFechaEmision(){
        return fechaEmision;
    }
    public void setFechaEmision(Date fechaEmision){
        this.fechaEmision = fechaEmision;
    }
    public String getFormaPago(){
        return formaPago;
    }
    public void setFormaPago(String formaPago){
        this.formaPago = formaPago;
    }
}
