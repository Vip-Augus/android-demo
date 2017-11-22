package cn.sevenyuan.demo.httpUtil;

import android.widget.Toast;

import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Response;

import java.util.concurrent.TimeoutException;

/**
 * Created by JingQ on 2017/11/22.
 */

public class DefaultResponseListener<T> implements OnResponseListener<Result<T>> {

    private HttpListener<T> listener;

    private AbstractRequest<T> request;

    public DefaultResponseListener(HttpListener<T> listener, AbstractRequest<T> request) {
        this.listener = listener;
        this.request = request;
    }

    @Override
    public void onStart(int what) {

    }

    @Override
    public void onSucceed(int what, Response<Result<T>> response) {
        if (listener != null) {
            listener.onSucceed(what, response.get());
        }
    }

    @Override
    public void onFailed(int what, Response<Result<T>> response) {
        Exception exception = response.getException();
        if (exception instanceof TimeoutException) {
            Logger.e("超时");
        }
        if (exception != null) {
            listener.onFailed(what);
        }
    }

    @Override
    public void onFinish(int what) {
        if (listener != null) {
            listener.onFinish(what);
        }
    }
}
