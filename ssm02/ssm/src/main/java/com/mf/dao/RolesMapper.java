package com.mf.dao;

import com.mf.entity.Roles;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolesMapper {
    @Select("select * from roles")
    public List<Roles> getRoles();
}
