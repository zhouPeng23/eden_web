package com.linkknown.eden.mapper;

import com.linkknown.eden.bean.AppModuleFlowStep;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
@Repository
public interface AppModuleFlowStepMapper {

    /**
     * 查询【步骤】
     *
     * @param stepId 【步骤】ID
     * @return 【步骤】
     */
    public AppModuleFlowStep selectAppModuleFlowStepById(Integer stepId);

    /**
     * 查询【步骤】列表
     *
     * @param appModuleFlowStep 【步骤】
     * @return 【步骤】集合
     */
    public List<AppModuleFlowStep> selectAppModuleFlowStepList(AppModuleFlowStep appModuleFlowStep);

    /**
     * 新增【步骤】
     *
     * @param appModuleFlowStep 【步骤】
     * @return 结果
     */
    public int insertAppModuleFlowStep(AppModuleFlowStep appModuleFlowStep);

    /**
     * 修改【步骤】
     *
     * @param appModuleFlowStep 【步骤】
     * @return 结果
     */
    public int updateAppModuleFlowStep(AppModuleFlowStep appModuleFlowStep);

    /**
     * 删除【步骤】
     *
     * @param stepId 【步骤】ID
     * @return 结果
     */
    public int deleteAppModuleFlowStepById(Integer stepId);


}
