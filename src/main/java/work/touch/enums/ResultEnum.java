package work.touch.enums;

/**
 * Created by Xu ZiPing on 2017/4/12.
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100, "你可能上小学"),
    MIDDLE_SCHOOL(101, "你可能上初中")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg  = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
