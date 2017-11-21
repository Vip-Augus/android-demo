package cn.sevenyuan.demo.httpUtil;

import com.alibaba.fastjson.JSON;
import com.yanzhenjie.nohttp.RequestMethod;

import java.util.List;

/**
 * Created by JingQ on 2017/11/21.
 */

public class EntityListRequest<T> extends AbstractRequest<List<T>> {

    private Class<List<T>> clazz;

    public EntityListRequest(String url, RequestMethod requestMethod, Class<List<T>> clazz) {
        super(url, requestMethod, clazz);
        this.clazz = clazz;
    }


    @Override
    public List<T> getResult(String data) {
        return (List<T>) JSON.parseArray(data, clazz);
    }
}
