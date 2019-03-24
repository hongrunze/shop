package com.corp.shop.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.SeqID;

import com.ibeetl.admin.core.util.ValidateConfig;

import org.beetl.sql.core.TailBean;
import java.math.*;

import com.ibeetl.admin.core.annotation.Dict;
import com.ibeetl.admin.core.entity.BaseEntity;

import org.beetl.sql.core.annotatoin.InsertIgnore;
import org.beetl.sql.core.annotatoin.Version;
import org.beetl.sql.core.annotatoin.LogicDelete;


/* 
* ???
* gen by Spring Boot2 Admin 2019-03-04
*/
public class MallItems extends BaseEntity{

    @NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
    @SeqID(name = ORACLE_CORE_SEQ_NAME)
    @AutoID	

    private Integer itemId ;
	

    private Integer shopId ;
	

    private Integer itemTypeId ;
	

    private Integer brandId ;
	

    private String itemName ;
	
    //????,json????

    private String itemDesc ;
	

    private Date createTime ;
	

    private Integer createBy ;
	

    private Date updateTime ;
	

    private Integer updateBy ;
	
    public MallItems()
    {
    }

    public Integer getItemId(){
	    return  itemId;
    }
    public void setItemId(Integer itemId){
        this.itemId = itemId;
    }

    public Integer getShopId(){
	    return  shopId;
    }
    public void setShopId(Integer shopId){
        this.shopId = shopId;
    }

    public Integer getItemTypeId(){
	    return  itemTypeId;
    }
    public void setItemTypeId(Integer itemTypeId){
        this.itemTypeId = itemTypeId;
    }

    public Integer getBrandId(){
	    return  brandId;
    }
    public void setBrandId(Integer brandId){
        this.brandId = brandId;
    }

    public String getItemName(){
	    return  itemName;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    /**????,json????
    *@return 
    */
    public String getItemDesc(){
	    return  itemDesc;
    }
    /**????,json????
    *@param  itemDesc
    */
    public void setItemDesc(String itemDesc){
        this.itemDesc = itemDesc;
    }

    public Date getCreateTime(){
	    return  createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Integer getCreateBy(){
	    return  createBy;
    }
    public void setCreateBy(Integer createBy){
        this.createBy = createBy;
    }

    public Date getUpdateTime(){
	    return  updateTime;
    }
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy(){
	    return  updateBy;
    }
    public void setUpdateBy(Integer updateBy){
        this.updateBy = updateBy;
    }


}
