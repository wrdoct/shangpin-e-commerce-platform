package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.entity.product.Brand;
import com.github.pagehelper.PageInfo;

public interface BrandService {

    PageInfo<Brand> findByPage(Integer page, Integer limit);

}
