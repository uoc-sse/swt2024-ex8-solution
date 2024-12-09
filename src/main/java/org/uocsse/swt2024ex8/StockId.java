package org.uocsse.swt2024ex8;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StockId implements Serializable {
    @Column(name = "store_id")
    private long storeId;

    @Column(name = "product_id")
    private long productId;

    public StockId() {}

    public StockId(long storeId, long productId) {
        this.storeId = storeId;
        this.productId = productId;
    }

    public long getStoreId() {
        return storeId;
    }

    public long getProductId() {
        return productId;
    }
}
