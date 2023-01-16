package pers.result;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer code;    //���ظ�ǰ�˵�״̬��
    private String msg;     //��״̬����н��͵���Ϣ
    private Object data;    //���ص�����

    public Result(){}

    public void setResultCode(Result_Code code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    //�ɹ���װ��״̬������Ϣ������
    public static Result success() {
        Result result = new Result();
        result.setResultCode(Result_Code.SUCCESS);
        return result;
    }

    //����success����,�˷�������һ��data
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
