package net.fakour.homeappliances.entity;

import javax.persistence.*;

@Entity
public class Comment1 {

    @Id
    @GeneratedValue
    private Long idComment;

    private String username;

    private String comment;

    private String code;

    private String category;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    @ManyToOne
//    @JoinColumn(name = "home_appliances_entity_id")
//    private HomeAppliancesEntity homeAppliancesEntity;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
