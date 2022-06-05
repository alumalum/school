package com.mf.service.impl;

import com.mf.dao.RolesMapper;
import com.mf.entity.Roles;
import com.mf.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RolesServiceImpl implements RolesService {

    @Autowired
    RolesMapper rolesMapper;

    @Override
    public List<Roles> getRoles() {
        return rolesMapper.getRoles();
    }
}
