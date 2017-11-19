package cn.sevenyuan.demo.model;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by JingQi on 2017/11/19.
 */

public class Book extends DataSupport implements Serializable {

    private static final long serialVersionUID = -5925952536219237348L;

    private int id;

    private String author;

    private BigDecimal price;

    private int pages;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", name='" + name + '\'' +
                '}';
    }
}
