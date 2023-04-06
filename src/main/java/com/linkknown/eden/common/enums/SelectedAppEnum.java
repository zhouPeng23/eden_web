package com.linkknown.eden.common.enums;

/**
 * @author zhoupeng
 * @date 2022/6/10 15:21
 */
public enum SelectedAppEnum {

    /**
     * 是否选择了此应用
     */
    YES(1, "已选择"),
    NO(0, "未选择");

    Integer code;
    String msg;

    SelectedAppEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
