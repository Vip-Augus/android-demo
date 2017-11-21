package cn.sevenyuan.demo.model;

import java.io.Serializable;

/**
 * Created by JingQ on 2017/11/20.
 */

public class SimpleMessage implements Serializable {

    private static final long serialVersionUID = -3416839159763383413L;

    private String portraitUrl;
    private String userName;
    private String leastMsg;
    private String time;

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLeastMsg() {
        return leastMsg;
    }

    public void setLeastMsg(String leastMsg) {
        this.leastMsg = leastMsg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "portraitUrl='" + portraitUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", leastMsg='" + leastMsg + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
