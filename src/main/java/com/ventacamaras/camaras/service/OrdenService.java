package com.ventacamaras.camaras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventacamaras.camaras.model.Carrito;
import com.ventacamaras.camaras.model.Orden;
import com.ventacamaras.camaras.model.Pago;
import com.ventacamaras.camaras.repository.CarritoRepository;
import com.ventacamaras.camaras.repository.OrdenRepository;
import com.ventacamaras.camaras.repository.PagoRepository;

import jakarta.transaction.Transactional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Transactional
    public Orden checkout(String username, String metodoPago){

        Carrito carrito =
                carritoRepository
                .findByUsuarioId(username)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Carrito no encontrado"));

        double total =
                carrito.getItems()
                .stream()
                .mapToDouble(i ->
                    i.getCantidad() *
                    i.getCamara().getPrecio())
                .sum();

        Orden orden = new Orden();

        orden.setUser(carrito.getUsuario());
        orden.setCarrito(carrito);
        orden.setTotal(total);
        orden.setEstado("PENDIENTE");

        ordenRepository.save(orden);

        Pago pago = new Pago();

        pago.setOrden(orden);
        pago.setMetodo(metodoPago);
        pago.setMonto(total);
        pago.setEstado("APROBADO");

        pagoRepository.save(pago);

        orden.setEstado("PAGADO");

        return ordenRepository.save(orden);
    }
}