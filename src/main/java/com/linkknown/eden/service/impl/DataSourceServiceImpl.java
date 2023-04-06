package com.linkknown.eden.service.impl;

import com.linkknown.eden.bean.DataSource;
import com.linkknown.eden.common.aspect.exception.EdenWebException;
import com.linkknown.eden.common.enums.ResponseEnum;
import com.linkknown.eden.mapper.DataSourceMapper;
import com.linkknown.eden.service.IDataSourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Service
public class DataSourceServiceImpl implements IDataSourceService {

    @Resource
    private DataSourceMapper dataSourceMapper;


    /**
     * 查询数据源集合
     * @param dataSource 查询参数
     * @return 集合
     */
    @Override
    public List<DataSource> queryDataSourceList(DataSource dataSource){
        if (StringUtils.isEmpty(dataSource.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        return dataSourceMapper.selectDataSourceList(dataSource);
    }

    /**
     * 添加数据源
     * @param dataSource 添加参数
     */
    @Override
    public void addDataSource(DataSource dataSource){
        if (StringUtils.isEmpty(dataSource.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getDataSourceName())){
            throw new EdenWebException(ResponseEnum.DATA_SOURCE_NAME_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getDriverClassName())){
            throw new EdenWebException(ResponseEnum.DRIVER_CLASS_NAME_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getUrl())){
            throw new EdenWebException(ResponseEnum.DS_URL_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getUsername())){
            throw new EdenWebException(ResponseEnum.USERNAME_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getPassword())){
            throw new EdenWebException(ResponseEnum.PASSWORD_CAN_NOT_BE_EMPTY);
        }
        dataSourceMapper.insertDataSource(dataSource);
    }

    /**
     * 删除数据源
     * @param dataSource 删除参数
     */
    @Override
    public void deleteDataSource(DataSource dataSource){
        if (StringUtils.isEmpty(dataSource.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getId())){
            throw new EdenWebException(ResponseEnum.DS_ID_CAN_NOT_BE_EMPTY);
        }
        dataSourceMapper.deleteDataSource(dataSource);
    }

    /**
     * 更新数据源
     * @param dataSource 更新参数
     */
    @Override
    public void updateDataSource(DataSource dataSource){
        if (StringUtils.isEmpty(dataSource.getAppId())){
            throw new EdenWebException(ResponseEnum.APP_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getId())){
            throw new EdenWebException(ResponseEnum.DS_ID_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getDataSourceName())){
            throw new EdenWebException(ResponseEnum.DATA_SOURCE_NAME_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getDriverClassName())){
            throw new EdenWebException(ResponseEnum.DRIVER_CLASS_NAME_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getUrl())){
            throw new EdenWebException(ResponseEnum.DS_URL_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getUsername())){
            throw new EdenWebException(ResponseEnum.USERNAME_CAN_NOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(dataSource.getPassword())){
            throw new EdenWebException(ResponseEnum.PASSWORD_CAN_NOT_BE_EMPTY);
        }
        dataSourceMapper.updateDataSource(dataSource);
    }


}
