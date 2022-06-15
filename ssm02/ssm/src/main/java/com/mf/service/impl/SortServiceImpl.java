package com.mf.service.impl;

import com.mf.dao.SortMapper;
import com.mf.entity.Sort;
import com.mf.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SortServiceImpl implements SortService {

    @Autowired
    SortMapper sortMapper;

    public List<Sort> getAllSort(){
       return sortMapper.getAllSort();
    }
}
