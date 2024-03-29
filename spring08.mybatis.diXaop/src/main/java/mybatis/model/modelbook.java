package mybatis.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class modelbook {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(modelbook.class);
    
    int bookid;
    String bookname;
    String publisher;
    String year;
    int price;
    String dtm;
    boolean use_yn;
    int authid;
    
    public int getBookid() {
        return bookid;
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDtm() {
        return dtm;
    }
    public void setDtm(String dtm) {
        this.dtm = dtm;
    }
    public boolean isUse_yn() {
        return use_yn;
    }
    public void setUse_yn(boolean use_yn) {
        this.use_yn = use_yn;
    }
    public int getAuthid() {
        return authid;
    }
    public void setAuthid(int authid) {
        this.authid = authid;
    }
    public modelbook(int bookid, String bookname, String publisher, String year,
            int price, String dtm, boolean use_yn, int authid) {
        super();
        this.bookid = bookid;
        this.bookname = bookname;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.dtm = dtm;
        this.use_yn = use_yn;
        this.authid = authid;
    }
    public modelbook() {
        super();
    }
    @Override
    public String toString() {
        return "modelbook [bookid=" + bookid + ", bookname=" + bookname
                + ", publisher=" + publisher + ", year=" + year + ", price="
                + price + ", dtm=" + dtm + ", use_yn=" + use_yn + ", authid="
                + authid + "]";
    }
    
    

}
