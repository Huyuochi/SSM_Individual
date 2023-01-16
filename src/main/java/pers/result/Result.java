package pers.result;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer code;    //返回给前端的状态码
    private String msg;     //对状态码进行解释的信息
    private Object data;    //返回的数据

    public Result(){}

    public void setResultCode(Result_Code code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    //成功则装入状态码与信息并返回
    public static Result success() {
        Result result = new Result();
        result.setResultCode(Result_Code.SUCCESS);
        return result;
    }

    //重载success方法,此方法返回一个data
    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(Result_Code.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setResultCode(Result_Code.ERROR);
        return result;
    }

    public void setData(Object data) {
        this.data = data;
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

    public Object getData() {
        return data;
    }
}
