package com.miniproject.catalog.controller;

import com.miniproject.catalog.entity.Catalog;
import com.miniproject.catalog.service.CatalogService;
import com.miniproject.catalog.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/catalog-service")
public class CatalogController {

    private final Environment env;
    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public String check() {
        return String.format("Catalog service Port : %s  is ON", env.getProperty("local.server.port"));

    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs(){
        Iterable<Catalog> allCatalogs = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();

        allCatalogs.forEach(v -> result.add(new ModelMapper().map(v, ResponseCatalog.class)));

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

}
