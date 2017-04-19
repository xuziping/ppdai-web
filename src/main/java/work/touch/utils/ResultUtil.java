package work.touch.utils;

import work.touch.domain.Result;

/**
 * Created by Xu ZiPing on 2017/4/13.
 */
public class ResultUtil {

    public static Result succ(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result succ() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(null);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
