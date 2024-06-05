package com.example.demo.Controladores;
import com.example.demo.Repositorios.FacturaRepository;
import com.example.demo.modulos.Factura;
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
