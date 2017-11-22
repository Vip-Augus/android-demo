# Android Demo


### 下拉更新和上拉加载更多
1. [EasyRefreshLayout](https://github.com/anzaizai/EasyRefreshLayout)
2. [RecyclerAdapter](http://www.jianshu.com/p/b343fcff51b0)


### yanzhenjie大神的NoHttp使用

**首先要在Application中的onCreate()方法中添加**
```
 @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoHttp.initialize(this);
    }
```

**封装解析JavaBean或者List\<JavaBean>，放在httpUtil目录下**

[根据业务代码进行封装解析](http://blog.csdn.net/yanzhenjie1003/article/details/70158030)

```
String url = "https://xxxxx";
EntityRequest<JavaBean> request = new EntityRequest<>(url, RequestMethod.GET, JavaBean.class);
CallServer.getInstance().request(1, request, new HttpListener<JavaBean>() {
     @Override
     public void onSucceed(int what, Result<JavaBean> result) {
          JavaBean javaBean = result.getResult();
     }

     @Override
     public void onFailed(int what) {

     }

     @Override
     public void onFinish(int what) {

     }
});
```