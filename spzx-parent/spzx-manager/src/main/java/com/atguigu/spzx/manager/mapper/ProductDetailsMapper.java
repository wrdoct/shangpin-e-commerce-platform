package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDetailsMapper {

    public abstract void save(ProductDetails productDetails);

    public abstract ProductDetails selectByProductId(Long id);

    public abstract void updateById(ProductDetails productDetails);

    public abstract void deleteByProductId(Long id);
}
