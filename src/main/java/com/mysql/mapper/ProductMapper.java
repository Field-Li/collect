package com.mysql.mapper;

import com.mysql.dto.ProductDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    /**
     * 根据产品id查找房东id
     * @param productId
     * @return
     */
    String selectProductOwnerId(@Param(value = "productId") Long productId);

    int updateByProductId(@Param(value = "productId") Long productId);

    /**
     * 根据房东id获取产品列表
     * @param ownerId
     * @return
     */
    List<ProductDto> selectOwnerProductList(@Param(value = "ownerId") String ownerId);
}
