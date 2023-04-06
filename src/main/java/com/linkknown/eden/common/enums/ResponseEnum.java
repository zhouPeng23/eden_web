package com.linkknown.eden.common.enums;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
public enum ResponseEnum {

    /**
     * 成功提示信息，都以0000开头
     */
    EDEN_WEB_SUCCESS                                                       ("0000", "成功"),
    ADD_SUCCESS                                                            ("0000", "添加成功"),
    DELETE_SUCCESS                                                         ("0000", "删除成功"),
    UPDATE_SUCCESS                                                         ("0000", "更新成功"),
    SELECTED_SUCCESS                                                       ("0000", "选择成功"),


    /**
     * 失败提示信息，三位数开头
     */
    EDEN_WEB_IS_BUSY                                                      ("0101", "系统忙,请稍候"),
    //================================================应用==============================================================
    APP_NAME_CAN_NOT_BE_EMPTY                                            ("0201", "应用名称不能为空"),
    APP_ID_CAN_NOT_BE_EMPTY                                              ("0202", "应用id不能为空"),
    SELECTED_APP_NUMBER_IN_DB_ERROR                                     ("0203", "数据库中已选择的app数量错误"),
    APP_IS_SELECTED_CAN_NOT_DELETE                                      ("0204", "应用正在被选择，无法删除"),
    APP_HAS_MODULES_CAN_NOT_DELETE                                      ("0205", "应用下已拥有模块，无法删除"),
    APP_HAS_DEFINEVARIABLE_CAN_NOT_DELETE                              ("0206", "应用下已拥有自定义变量，无法删除"),
    APP_HAS_DATASOURCE_CAN_NOT_DELETE                                   ("0207", "应用下已拥有数据源，无法删除"),
    //================================================自定义变量========================================================
    VAR_NAME_CAN_NOT_BE_EMPTY                                            ("0301", "变量名不能为空"),
    VAR_VALUE_CAN_NOT_BE_EMPTY                                           ("0302", "变量值不能为空"),
    VAR_ID_CAN_NOT_BE_EMPTY                                              ("0303", "变量id不能为空"),
    //================================================模块==============================================================
    MODULE_NAME_CAN_NOT_BE_EMPTY                                         ("0401", "模块名称不能为空"),
    MODULE_ID_CAN_NOT_BE_EMPTY                                           ("0402", "模块id不能为空"),
    MODULE_HAS_FLOW_CAN_NOT_DELETE                                      ("0403", "模块下已拥有流程，无法删除"),
    //================================================数据源============================================================
    DATA_SOURCE_NAME_CAN_NOT_BE_EMPTY                                   ("0501", "数据源名称不能为空"),
    DRIVER_CLASS_NAME_CAN_NOT_BE_EMPTY                                  ("0502", "驱动名称不能为空"),
    DS_URL_CAN_NOT_BE_EMPTY                                              ("0503", "数据源url不能为空"),
    USERNAME_CAN_NOT_BE_EMPTY                                            ("0504", "用户名不能为空"),
    PASSWORD_CAN_NOT_BE_EMPTY                                            ("0505", "密码不能为空"),
    DS_ID_CAN_NOT_BE_EMPTY                                               ("0506", "数据源id不能为空"),
    //================================================应用模块流程======================================================
    FLOW_NAME_CAN_NOT_BE_EMPTY                                           ("0601", "流程名称不能为空"),
    FLOW_ID_CAN_NOT_BE_EMPTY                                             ("0602", "流程id不能为空"),





    PLEASE_CONTACT_THE_ADMINISTRATOR                                    ("9999", "请联系管理员");

    String code;
    String msg;

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
