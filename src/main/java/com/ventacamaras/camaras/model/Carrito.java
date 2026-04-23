package com.ventacamaras.camaras.model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items = new ArrayList<>();

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }
}