package cn.sevenyuan.demo.httpUtil;

/**
 * Created by JingQ on 2017/11/22.
 */

public interface HttpListener<T> {

    void onSucceed(int what, Result<T> result);

    void onFailed(int what);

    void onFinish(int what);
}
