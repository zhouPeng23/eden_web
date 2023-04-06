package com.linkknown.eden.service;


import com.linkknown.eden.bean.DefineVariable;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
public interface IDefineVariableService {

    /**
     * 查询变量集合
     * @param defineVariable 查询参数
     * @return 变量集合
     */
    public List<DefineVariable> queryVariableList(DefineVariable defineVariable);

    /**
     * 添加变量
     * @param defineVariable 添加参数
     */
    public void addVariable(DefineVariable defineVariable);

    /**
     * 删除变量
     * @param defineVariable 删除参数
     */
    public void deleteVariable(DefineVariable defineVariable);

    /**
     * 更新变量
     * @param defineVariable 更新参数
     */
    public void updateVariable(DefineVariable defineVariable);
}
