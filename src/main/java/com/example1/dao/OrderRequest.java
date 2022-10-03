package com.example1.dao;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Setter
@Getter
public class OrderRequest {


    private Long userId;
    private List<Long> productIds;
    private HashMap<Long, Integer> productMap;



}
