package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PCB_DIC_ITEM")
public class PcbDicItem implements Serializable {

    private static final long serialVersionUID = 3541017773340846824L;

    @Id
    @Column(name = "ITEM_ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|20|", length = 20, nullable = false)
    private Long itemId;

    @Column(name = "DIC_CODE", columnDefinition = "VARCHAR2|字典域编码|20|", length = 20, nullable = true)
    private String dicCode;

    @Column(name = "ITEM_CODE", columnDefinition = "VARCHAR2|ids中对应的编码|60|", length = 50, nullable = true)
    private String itemCode;

    @Column(name = "ITEM_NAME", columnDefinition = "VARCHAR2|字典名称|500|", length = 500, nullable = true)
    private String itemName;

    @Column(name = "PY_CODE", columnDefinition = "VARCHAR2|拼音码|50|", length = 50, nullable = true)
    private String pyCode;

    @Column(name = "WB_CODE", columnDefinition = "VARCHAR2|五笔码|50|", length = 50, nullable = true)
    private String wbCode;

    @Column(name = "CS1", columnDefinition = "VARCHAR2|扩展字符型字段1|200|", length = 200, nullable = true)
    private String cs1;

    @Column(name = "CS2", columnDefinition = "VARCHAR2|扩展字符型字段2|200|", length = 200, nullable = true)
    private String cs2;

    @Column(name = "ITEM_SORT", columnDefinition = "VARCHAR2|排序||", length = 1, nullable = true)
    private String itemSort;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    public String getWbCode() {
        return wbCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode;
    }

    public String getCs1() {
        return cs1;
    }

    public void setCs1(String cs1) {
        this.cs1 = cs1;
    }

    public String getCs2() {
        return cs2;
    }

    public void setCs2(String cs2) {
        this.cs2 = cs2;
    }

    public String getItemSort() {
        return itemSort;
    }

    public void setItemSort(String itemSort) {
        this.itemSort = itemSort;
    }
}