package cn.sevenyuan.demo.httpUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.RestRequest;
import com.yanzhenjie.nohttp.rest.StringRequest;

/**
 * Created by JingQ on 2017/11/21.
 */

public abstract class AbstractRequest<T> extends RestRequest<Result<T>> {

    private Class<T> clazz;

    public AbstractRequest(String url, Class<T> clazz) {
        super(url);
        this.clazz = clazz;
    }

    public AbstractRequest(String url, RequestMethod requestMethod, Class<T> clazz) {
        super(url, requestMethod);
        this.clazz = clazz;
    }

    public abstract T getResult(String data);

    @Override
    public Result<T> parseResponse(Headers headers, byte[] body) throws Exception {
        //响应码
        int responseCode = headers.getResponseCode();

        //响应码等于200，Http层成功
        if (responseCode == 200) {
            if (body == null || body.length == 0) {
                //服务器返回空
                return new Result<>(true, null, headers, null);
            } else {
                //成功返回的数据
                String bodyString = StringRequest.parseResponseString(headers, body);
                try {
                    JSONObject bodyObject = JSON.parseObject(bodyString);
                    //业务层成功
                    if (bodyObject.getIntValue("errorCode") == 1) {
                        String data = bodyObject.getString("data");
                        T result = getResult(data);
                        return new Result<>(true, result, headers, null);
                    } else {
//                        String error = bodyObject.getString("message");
//                        return new Result<>(false, null, headers, error);
                        T result = getResult(bodyString);
                        return new Result<>(true, result, headers, null);
                    }
                } catch (Exception e) {
                    //解析异常
                    String error = e.getMessage();
                    return new Result<>(false, null, headers, error);
                }
            }
        } else {
            String error = "服务器返回其它相应码未识别";
            return new Result<>(false, null, headers, error);
        }


    }
}
