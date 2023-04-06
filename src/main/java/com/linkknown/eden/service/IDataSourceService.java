package com.linkknown.eden.service;


import com.linkknown.eden.bean.DataSource;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
public interface IDataSourceService {

    /**
     * 查询数据源集合
     * @param dataSource 查询参数
     * @return 集合
     */
    public List<DataSource> queryDataSourceList(DataSource dataSource);

    /**
     * 添加数据源
     * @param dataSource 添加参数
     */
    public void addDataSource(DataSource dataSource);

    /**
     * 删除数据源
     * @param dataSource 删除参数
     */
    public void deleteDataSource(DataSource dataSource);

    /**
     * 更新数据源
     * @param dataSource 更新参数
     */
    public void updateDataSource(DataSource dataSource);
}
