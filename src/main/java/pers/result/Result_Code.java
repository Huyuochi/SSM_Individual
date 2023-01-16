package pers.result;

public enum Result_Code {

    // 成功状态码,两个做测试
    SUCCESS(0, "成功"),
    ERROR(1, "失败");

    private Integer code;
    private String msg;

    Result_Code(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
