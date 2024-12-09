package org.uocsse.swt2024ex8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class StockController {
    private StockRepository stockRepository;
    private ProductRepository productRepository;

    @Autowired
    public StockController(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/totalstockvalue")
    public HashMap<String, Integer> getTotalStockValue() {
        var stocks = stockRepository.findAll();
        var totalValue = 0;

        for (var stock : stocks) {
            var product = productRepository.findById(stock.getId().getProductId()).get();
            totalValue += stock.getQuantity() * product.getPrice();
        }

        var res = new HashMap<String, Integer>();
        res.put("total", totalValue);
        return res;
    }
}
