package com.ventacamaras.camaras.service;

import com.ventacamaras.camaras.model.Pago;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private List<Pago> pagos = new ArrayList<>();


    public Pago registrarPago(double monto, String metodo, int ordenId, String estado) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        Pago pago = new Pago(pagos.size() + 1, monto, metodo, estado, ordenId);
        pagos.add(pago);
        return pago;
    }


    public List<Pago> listarPagos() {
        return pagos;
    }

    public List<Pago> pagosPorOrden(int ordenId) {
        return pagos.stream()
                .filter(p -> p.getOrdenId() == ordenId)
                .toList();
    }

    public Optional<Pago> obtenerPorId(int pagoId) {
        return pagos.stream()
                .filter(p -> p.getId() == pagoId)
                .findFirst();
    }

    public List<Pago> pagosPorEstado(String estado) {
        return pagos.stream()
                .filter(p -> p.getEstado().equals(estado))
                .toList();
    }

    public boolean cambiarEstado(int pagoId, String nuevoEstado) {
        Optional<Pago> pago = obtenerPorId(pagoId);
        if (pago.isPresent()) {
            pago.get().setEstado(nuevoEstado);
            return true;
        }
        return false;
    }
}
