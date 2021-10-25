package com.example.demo.YgoCardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "datas")
@Entity
public class Data {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ot")
    private Integer ot;

    @Column(name = "alias")
    private Long alias;

    @Column(name = "setcode")
    private Integer setcode;

    @Column(name = "type")
    private Integer type;

    @Column(name = "atk")
    private Integer atk;

    @Column(name = "def")
    private Integer def;

    @Column(name = "level")
    private Integer level;

    @Column(name = "race")
    private Integer race;

    @Column(name = "attribute")
    private Integer attribute;

    @Column(name = "category")
    private Integer category;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSetcode() {
        return setcode;
    }

    public void setSetcode(Integer setcode) {
        this.setcode = setcode;
    }

    public Long getAlias() {
        return alias;
    }

    public void setAlias(Long alias) {
        this.alias = alias;
    }

    public Integer getOt() {
        return ot;
    }

    public void setOt(Integer ot) {
        this.ot = ot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}