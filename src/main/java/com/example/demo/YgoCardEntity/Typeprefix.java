package com.example.demo.YgoCardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "typeprefix")
@Entity
public class Typeprefix {
    @Id
    @Column(name = "type", nullable = false)
    private Integer id;

    @Column(name = "chinesetype", nullable = false)
    private String chinesetype;

    @Column(name = "ismagicortrap", nullable = false)
    private Boolean ismagicortrap = false;

    public Boolean getIsmagicortrap() {
        return ismagicortrap;
    }

    public void setIsmagicortrap(Boolean ismagicortrap) {
        this.ismagicortrap = ismagicortrap;
    }

    public String getChinesetype() {
        return chinesetype;
    }

    public void setChinesetype(String chinesetype) {
        this.chinesetype = chinesetype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}