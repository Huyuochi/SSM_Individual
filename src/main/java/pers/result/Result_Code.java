package pers.result;

public enum Result_Code {

    // �ɹ�״̬��,����������
    SUCCESS(0, "�ɹ�"),
    ERROR(1, "ʧ��");

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
