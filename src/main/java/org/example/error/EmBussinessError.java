package org.example.error;

public enum EmBussinessError implements CommonError {
    // 全局错误码

    // 00001
    PARAMETER_VALISATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),

    // 20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001,"用户不存在")

    ;

    EmBussinessError(int errCode, String errMsg){
        this.errCode=errCode;
        this.errMsg=errMsg;
    }
    private int errCode;
    private String errMsg;


    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg=errMsg;
        return this;
    }
}
