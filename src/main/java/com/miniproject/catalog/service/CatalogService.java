package com.miniproject.catalog.service;

import com.miniproject.catalog.entity.Catalog;

public interface CatalogService {
    Iterable<Catalog> getAllCatalogs();
}
