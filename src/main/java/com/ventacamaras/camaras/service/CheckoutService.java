package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Orden;
import com.ventacamaras.camaras.model.Pago;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final OrdenService ordenService;

    private final PagoService pagoService;

    public CheckoutService(OrdenService ordenService, PagoService pagoService) {
        this.ordenService = ordenService;
        this.pagoService = pagoService;
    }

    public Pago realizarCompra(int ordenId, String metodo, String estado) {
        Orden orden = ordenService.obtenerPorId(ordenId);

        if (orden == null) {
            throw new RuntimeException("Orden no encontrada");
        }

        // aca se verificaria si hay stock

        //se llamara pasarela de pago
        Pago pago = pagoService.registrarPago(orden.getCantidad(), metodo, ordenId,estado);

        if (pago != null && pago.getEstado().equals("COMPLETADO")) {
            // Aca luego se reduciria el stock
        }

        return pago;
    }
}

