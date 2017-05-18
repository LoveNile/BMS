package com.bms.mapper;

import java.util.List;

import com.bms.vo.CategoryCustom;

public interface CategoryCustomMapper {
    List<CategoryCustom> getAllCategory();
    int countCategoryname(String name);
}
