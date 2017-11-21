package cn.sevenyuan.demo.httpUtil;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

/**
 * Created by JingQ on 2017/11/21.
 */

public class CallServer {

    private static CallServer instance;

    public static CallServer getInstance() {
        if (instance == null) {
            synchronized (CallServer.class) {
                if (instance == null) {
                    instance = new CallServer();
                }
            }
        }
        return instance;
    }

    private RequestQueue requestQueue;

    private CallServer() {
        requestQueue = NoHttp.newRequestQueue(5);
    }

    public <T> void request(int what, Request<T> request, SimpleResponseListener<T> listener) {
        requestQueue.add(what, request, listener);
    }

    //完全退出App时,调用这个方法释放CPU
    public void stop() {
        requestQueue.stop();
    }
}
