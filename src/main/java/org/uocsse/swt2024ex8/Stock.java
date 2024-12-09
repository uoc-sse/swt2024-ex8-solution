package org.uocsse.swt2024ex8;

import jakarta.persistence.*;

@Entity
public class Stock {
    @EmbeddedId
    private StockId id;

    private int quantity;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private Store store;

    public Stock() {}

    public Stock(StockId id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public StockId getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
