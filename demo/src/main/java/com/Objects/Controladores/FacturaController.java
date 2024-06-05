package com.Objects.Controladores;
import com.Objects.Repositorios.FacturaRepository;
import com.Objects.modulos.Factura;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Factura")
public class FacturaController {
    @Autowired
    private FacturaRepository facturaRepository;
    @GetMapping
    public List<Factura> getAllFacturas(){
        return facturaRepository.findAll();
    }
    @PostMapping
    public Factura createFactura(@RequestBody Factura factura){
        return facturaRepository.save(factura);
    }
}
