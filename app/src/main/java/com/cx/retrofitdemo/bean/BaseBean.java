package com.cx.retrofitdemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengxiao on 2018/6/5.
 */

public class BaseBean<T> {


    private int Code;
    private boolean Success = false;
    private String Errors = "";
    private ResultState resultState = ResultState.DEFAULT;
    private List<T> Data;
    //    private List<IndexPreferredDataBean> Data;


    public ResultState getResultState() {
        return resultState;
    }

    public BaseBean<T> setResultState(ResultState resultState) {
        this.resultState = resultState;
        return this;
    }


    public boolean isSuccess() {
        return Success;
    }

    public BaseBean<T> setSuccess(boolean success) {
        Success = success;
        return this;
    }

    public String getErrors() {
        return Errors == null ? "" : Errors;
    }

    public BaseBean<T> setErrors(String errors) {
        Errors = errors;
        return this;
    }

    public List<T> getData() {
        if (Data == null) {
            return new ArrayList<>();
        }
        return Data;
    }

    public BaseBean<T> setData(List<T> data) {
        Data = data;
        return this;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }


    @Override
    public String toString() {
        return "BaseBean{" +
                "Code=" + Code +
                ", Success=" + Success +
                ", Errors='" + Errors + '\'' +
                ", Data=" + Data +
                '}';
    }
}
