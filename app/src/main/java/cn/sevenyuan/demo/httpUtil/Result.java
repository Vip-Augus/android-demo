package cn.sevenyuan.demo.httpUtil;

import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.rest.RestRequest;

/**
 * Created by JingQ on 2017/11/21.
 */

public class Result<T> {
    private boolean isSucceed; //业务和Http层是否成功
    private T result;          //结果
    private Headers headers;   //Http相应头
    private String error;      //错误提示信息

    public Result(boolean isSucceed, T result, Headers headers, String error) {
        this.isSucceed = isSucceed;
        this.result = result;
        this.headers = headers;
        this.error = error;
    }

    public boolean isSucceed() {
        return isSucceed;
    }

    public T getResult() {
        return result;
    }

    public Headers getHeaders() {
         return headers;
    }

    public String getError() {
        return error;
    }
}
