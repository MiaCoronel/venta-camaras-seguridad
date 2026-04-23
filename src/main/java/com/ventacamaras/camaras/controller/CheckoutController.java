package com.ventacamaras.camaras.controller;

import com.ventacamaras.camaras.model.Pago;
import com.ventacamaras.camaras.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/{ordenId}")
    public Pago pagarOrden(@PathVariable int ordenId, @RequestParam String metodo, @RequestParam String estado) {
        return checkoutService.realizarCompra(ordenId, metodo, estado);
    }
}