package com.linkknown.eden.mapper;

import com.linkknown.eden.bean.DataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Repository
public interface DataSourceMapper {

    /**
     * 查询【数据库资源】
     *
     * @param id 【数据库资源】ID
     * @return 【数据库资源】
     */
    public DataSource selectDataSourceById(Integer id);

    /**
     * 查询【数据库资源】列表
     *
     * @param dataSource 【数据库资源】
     * @return 【数据库资源】集合
     */
    public List<DataSource> selectDataSourceList(DataSource dataSource);

    /**
     * 新增【数据库资源】
     *
     * @param dataSource 【数据库资源】
     * @return 结果
     */
    public int insertDataSource(DataSource dataSource);

    /**
     * 修改【数据库资源】
     *
     * @param dataSource 【数据库资源】
     * @return 结果
     */
    public int updateDataSource(DataSource dataSource);

    /**
     * 删除【数据库资源】
     *
     * @param dataSource 【数据库资源】
     * @return 结果
     */
    public int deleteDataSource(DataSource dataSource);

}
