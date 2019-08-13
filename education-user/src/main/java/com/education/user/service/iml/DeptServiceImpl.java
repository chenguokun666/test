package com.education.user.service.iml;

import com.education.user.mapper.DeptMapper;
import com.education.user.pojo.Dept;
import com.education.user.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> deptList() {
        return deptMapper.findAll();
    }
}
