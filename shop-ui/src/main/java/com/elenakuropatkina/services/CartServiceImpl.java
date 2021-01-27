package com.elenakuropatkina.services;

import com.elenakuropatkina.controllers.represents.ProductRepresent;
import com.elenakuropatkina.services.models.OrderItem;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    private static final long serialVersionUID = -9025621122549454991L;

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private final Map<OrderItem, Integer> orderItems;

    @PostConstruct
    public void post() {
        logger.info("Session bean post construct");
    }

    public CartServiceImpl() {
        this.orderItems = new HashMap<>();
    }

    @JsonCreator
    public CartServiceImpl(@JsonProperty("orderItems") List<OrderItem> orderItems) {
        this.orderItems = orderItems.stream().collect(Collectors.toMap(li -> li, OrderItem::getQty));
    }

    @Override
    public void addProductQty(ProductRepresent productRepresent, int qty) {
        OrderItem orderItem = new OrderItem(productRepresent);
        orderItems.put(orderItem, orderItems.getOrDefault(orderItem, 0) + qty);
    }

    @Override
    public void removeProductQty(ProductRepresent productRepresent, int qty) {
        OrderItem orderItem = new OrderItem(productRepresent);
        int currentQty = orderItems.getOrDefault(orderItem, 0);
        if (currentQty - qty > 0) {
            orderItems.put(orderItem, currentQty - qty);
        } else {
            orderItems.remove(orderItem);
        }
    }

    @Override
    public void removeProduct(ProductRepresent productRepresent) {
        orderItems.remove(new OrderItem(productRepresent));
    }

    @Override
    public List<OrderItem> getOrderItems() {
        orderItems.forEach(OrderItem::setQty);
        return new ArrayList<>(orderItems.keySet());
    }

    @JsonIgnore
    @Override
    public BigDecimal getSubTotal() {
        orderItems.forEach(OrderItem::setQty);
        return orderItems.keySet().stream()
                .map(OrderItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void updateCart(OrderItem orderItem) {
        orderItems.put(orderItem, orderItem.getQty());
    }
}
