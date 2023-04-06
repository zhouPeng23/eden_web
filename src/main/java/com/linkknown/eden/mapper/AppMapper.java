package com.linkknown.eden.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linkknown.eden.bean.App;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Repository
public interface AppMapper extends BaseMapper<App> {
    /**
     * 查询【应用】
     *
     * @param appId 【应用】ID
     * @return 【应用】
     */
    public App selectAppById(Integer appId);

    /**
     * 查询【应用】列表
     *
     * @param app 【应用】
     * @return 【应用】集合
     */
    public List<App> selectAppList(App app);

    /**
     * 新增【应用】
     *
     * @param app 【应用】
     * @return 结果
     */
    public int insertApp(App app);

    /**
     * 修改【应用】
     *
     * @param app 【应用】
     * @return 结果
     */
    public int updateApp(App app);

    /**
     * 删除【应用】
     *
     * @param appId 【应用】ID
     * @return 结果
     */
    public int deleteAppById(Integer appId);

}
