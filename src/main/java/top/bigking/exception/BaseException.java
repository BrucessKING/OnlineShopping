package top.bigking.exception;

/**
 * @Author ABKing
 * @since 2020/5/15 下午11:38
 **/
public class BaseException extends RuntimeException {
    private Integer code;
    private String msg;

    public BaseException() {
    }

    public BaseException(Integer code, String msg) {
        super(msg);
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
