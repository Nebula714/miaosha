package org.example.error;

import java.io.BufferedInputStream;

public class BussinessException extends Exception implements CommonError {

    private CommonError commonError;

    public BussinessException(CommonError commonError){
        super();
        this.commonError=commonError;
    }

    //接收自定义errMsg
    public BussinessException(CommonError commonError, String errMsg){
        super();
        this.commonError=commonError;
        commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this.commonError;
    }
}
