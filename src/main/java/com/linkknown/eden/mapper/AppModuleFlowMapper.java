package com.linkknown.eden.mapper;

import com.linkknown.eden.bean.AppModuleFlow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Repository
public interface AppModuleFlowMapper {

    /**
     * 查询【流程】
     *
     * @param flowId 【流程】ID
     * @return 【流程】
     */
    public AppModuleFlow selectAppModuleFlowById(Integer flowId);

    /**
     * 查询【流程】列表
     *
     * @param appModuleFlow 【流程】
     * @return 【流程】集合
     */
    public List<AppModuleFlow> selectAppModuleFlowList(AppModuleFlow appModuleFlow);

    /**
     * 新增【流程】
     *
     * @param appModuleFlow 【流程】
     * @return 结果
     */
    public int insertAppModuleFlow(AppModuleFlow appModuleFlow);

    /**
     * 修改【流程】
     *
     * @param appModuleFlow 【流程】
     * @return 结果
     */
    public int updateAppModuleFlow(AppModuleFlow appModuleFlow);

    /**
     * 删除【流程】
     *
     * @param appModuleFlow 【流程】
     * @return 结果
     */
    public int deleteAppModuleFlow(AppModuleFlow appModuleFlow);


}
