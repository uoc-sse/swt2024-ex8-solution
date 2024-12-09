package org.uocsse.swt2024ex8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String location;

    @OneToMany(mappedBy = "store")
    private List<Employee> employees;

    @OneToMany(mappedBy = "store")
    private List<Stock> stocks;
}
