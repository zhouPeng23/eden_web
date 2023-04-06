package com.linkknown.eden.mapper;

import com.linkknown.eden.bean.DefineVariable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Repository
public interface DefineVariableMapper {

    /**
     * 查询【自定义变量】
     *
     * @param id 【自定义变量】ID
     * @return 【自定义变量】
     */
    public DefineVariable selectDefineVariableById(Integer id);

    /**
     * 查询【自定义变量】列表
     *
     * @param defineVariable 【自定义变量】
     * @return 【自定义变量】集合
     */
    public List<DefineVariable> selectDefineVariableList(DefineVariable defineVariable);

    /**
     * 新增【自定义变量】
     *
     * @param defineVariable 【自定义变量】
     * @return 结果
     */
    public int insertDefineVariable(DefineVariable defineVariable);


    /**
     * 删除【自定义变量】
     *
     * @param defineVariable 【自定义变量】
     * @return 结果
     */
    public int deleteDefineVariable(DefineVariable defineVariable);


    /**
     * 修改【自定义变量】
     *
     * @param defineVariable 【自定义变量】
     * @return 结果
     */
    public int updateDefineVariable(DefineVariable defineVariable);

}
