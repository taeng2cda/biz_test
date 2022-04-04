package VO;

import java.util.Date;

public class PostsVo {
    private int id;
    private String title;
    private String content;
    private int user_id;
    private Date created_at;
    private Date updated_at;

    // 유저테이블의 이메일 가상 컬럼
    private String email;
    //데이터 포맷 가상컬럼
    private String format_created_at;
    private String format_updatred_at;


    @Override
    public String toString() {
        return "PostsVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user_id=" + user_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", email='" + email + '\'' +
                '}';
    }

    public PostsVo(){}
    public PostsVo(int id, String title, String content, int user_id, Date created_at, Date updated_at)  {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // inner join을 위한 생성자 오버로딩
    public PostsVo(int id, String title, String content, String email, Date created_at, Date updated_at ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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


    //가상컬럼 게터 세터
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    //포맷데이터 게터 세터
    public String getFormat_created_at() {
        return format_created_at;
    }
    public void setFormat_created_at(String format_created_at) {
        this.format_created_at = format_created_at;
    }
    public String getFormat_updatred_at() {
        return format_updatred_at;
    }
    public void setFormat_updatred_at(String format_updatred_at) {
        this.format_updatred_at = format_updatred_at;
    }
}
