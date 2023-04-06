package com.linkknown.eden.mapper;

import com.linkknown.eden.bean.AppModule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Repository
public interface AppModuleMapper {

    /**
     * 查询【模块】
     *
     * @param moduleId 【模块】ID
     * @return 【模块】
     */
    public AppModule selectAppModuleById(Integer moduleId);

    /**
     * 查询【模块】列表
     *
     * @param appModule 【模块】
     * @return 【模块】集合
     */
    public List<AppModule> selectAppModuleList(AppModule appModule);

    /**
     * 新增【模块】
     *
     * @param appModule 【模块】
     * @return 结果
     */
    public int insertAppModule(AppModule appModule);

    /**
     * 修改【模块】
     *
     * @param appModule 【模块】
     * @return 结果
     */
    public int updateAppModule(AppModule appModule);

    /**
     * 删除【模块】
     *
     * @param appModule 【模块】
     * @return 结果
     */
    public int deleteAppModule(AppModule appModule);

}
