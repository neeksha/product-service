package com.amazon.productservice.dao.respository;

import com.amazon.productservice.dao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
