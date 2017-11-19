package cn.sevenyuan.demo.model;

import java.io.Serializable;

/**
 * Created by JingQi on 2017/11/19.
 */

public class News implements Serializable {

    private static final long serialVersionUID = -2955763309778447639L;

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
