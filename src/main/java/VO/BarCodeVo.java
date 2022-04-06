package VO;

import java.util.Date;

public class BarCodeVo {
    private int id;
    private String barcodeKey;
    private String title;
    private String content;
    private Date created_at;
    private Date updated_at;

    public BarCodeVo() {}

    public BarCodeVo(int id, String barcodeKey, String title, String content, Date created_at, Date updated_at) {
        this.id = id;
        this.barcodeKey = barcodeKey;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcodeKey() {
        return barcodeKey;
    }

    public void setBarcodeKey(String barcodeKey) {
        this.barcodeKey = barcodeKey;
    }

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
