package com.miniproject.catalog.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CatalgDto implements Serializable {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String userId;
    private String orderId;

}
