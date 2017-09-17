package entities;

import java.sql.Date;

/**
 *
 * @author tha
 */
public class Article {
    private String header;
    private String caption;
    private String body;
    private Date inserted;

    public Article(String header, String caption, String body, Date inserted) {
        this.header = header;
        this.caption = caption;
        this.body = body;
        this.inserted = inserted;
    }

    public Article() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getInserted() {
        return inserted;
    }

    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }
    
}
