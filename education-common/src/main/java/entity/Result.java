package entity;

public class Result {

    private Boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public Boolean getFlag() {
        return flag;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public Result(Boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(Boolean flag, Integer code, Object data) {
        this.flag = flag;
        this.code = code;
        this.data = data;
    }

    public Result() {
    }
}
