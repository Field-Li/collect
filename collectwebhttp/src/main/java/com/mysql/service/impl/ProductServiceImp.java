package com.mysql.service.impl;

import com.mysql.mapper.ProductMapper;
import com.mysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lifana on 2017/2/4.
 */
public class ProductServiceImp implements ProductService {

    private ProductMapper productMapper;

    public String getProduct(Long productId){
        return productMapper.selectProductOwnerId(productId);
    }

    public int updateByProductId(Long productId){
        return productMapper.updateByProductId(productId);
    }
}
