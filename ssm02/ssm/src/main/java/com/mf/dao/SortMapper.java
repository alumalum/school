package com.mf.dao;

import com.mf.entity.Sort;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SortMapper {
    @Select("select * from sort")
    public List<Sort> getAllSort();
}
