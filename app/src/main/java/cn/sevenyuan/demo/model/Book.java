package cn.sevenyuan.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by JingQ on 2017/11/22.
 */

public class Book implements Serializable{

    private static final long serialVersionUID = -5925952536219237348L;

    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private String bookImage;

    private BigDecimal bookPrice;

    private String bookPublisher;

    private String bookPublishDate;

    private Integer bookStatus;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(String bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookPublishDate='" + bookPublishDate + '\'' +
                ", bookStatus=" + bookStatus +
                '}';
    }
}
