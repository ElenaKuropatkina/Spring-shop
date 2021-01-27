package com.elenakuropatkina.services;

import com.elenakuropatkina.controllers.represents.ProductRepresent;
import com.elenakuropatkina.services.models.OrderItem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface CartService extends Serializable {

    void addProductQty(ProductRepresent productRepresent, int qty);

    void removeProductQty(ProductRepresent productRepresent, int qty);

    void removeProduct(ProductRepresent productRepresent);

    List<OrderItem> getOrderItems();

    BigDecimal getSubTotal();

    void updateCart(OrderItem orderItem);
    }


