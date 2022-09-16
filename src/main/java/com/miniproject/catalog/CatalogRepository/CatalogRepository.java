package com.miniproject.catalog.CatalogRepository;

import com.miniproject.catalog.entity.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Long> {
    Catalog findByProductId(String productId);
}
