package cn.sevenyuan.demo.model;

import java.io.Serializable;

/**
 * Test Model
 * Created by JingQ on 2017/11/16.
 */

public class TestModel implements Serializable {

    private static final long serialVersionUID = 7361929056188578531L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
