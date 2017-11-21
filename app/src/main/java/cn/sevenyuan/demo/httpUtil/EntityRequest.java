package cn.sevenyuan.demo.httpUtil;

import com.alibaba.fastjson.JSON;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.RestRequest;
import com.yanzhenjie.nohttp.rest.StringRequest;

/**
 * Created by JingQ on 2017/11/21.
 */

public class EntityRequest<T> extends AbstractRequest<T> {

    private Class<T> clazz;


    public EntityRequest(String url, RequestMethod requestMethod, Class<T> clazz) {
        super(url, requestMethod, clazz);
    }

    @Override
    public T getResult(String data) {
        return JSON.parseObject(data, clazz);
    }
}
