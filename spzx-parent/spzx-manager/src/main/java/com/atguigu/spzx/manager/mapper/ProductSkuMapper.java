package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSkuMapper {

    public abstract void save(ProductSku productSku);

    public abstract List<ProductSku> selectByProductId(Long id);

    public abstract  void updateById(ProductSku productSku);

    public abstract void deleteByProductId(Long id);
}
