package main.java.VO;

import java.util.Date;


public class UserTableVo {
    private String id;
    private String email;
    private String name;
    private String password;
    private Date created_at;
    private Date updated_at;

    public UserTableVo(){}
    public UserTableVo(String id, String password, String email, String name , Date created_at, Date updated_at){
        this.id=id;
        this.password=password;
        this.email=email;
        this.name=name;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
