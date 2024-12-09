package org.uocsse.swt2024ex8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {
    private ProductRepository productRepository;
    private StockRepository stockRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, StockRepository stockRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam long id) {
        if (productRepository.existsById(id)) {
            return new ResponseEntity<>(productRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    public ResponseEntity<Void> deleteProduct(@RequestParam long id) {
        if (productRepository.existsById(id)) {
            var stocks = productRepository.findById(id).get().getStocks();
            stockRepository.deleteAll(stocks);
            productRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
