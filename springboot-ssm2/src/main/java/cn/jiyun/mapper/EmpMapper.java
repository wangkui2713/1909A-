package cn.jiyun.mapper;

import cn.jiyun.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper {
    void addEmp(@Param(value="emp") Emp emp);

    List<Emp> findAll();

    void delEmpById(@Param(value="eid") Integer eid);

    void updateEmp(Emp emp);

    Emp updateEmpId(Integer eid);
}
