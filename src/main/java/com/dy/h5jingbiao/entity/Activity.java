package com.dy.h5jingbiao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName(value = "activity")
public class Activity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer activityId;//活动编号
    private String activityName;//竞标名称

    @TableField(exist = false)
    private List<Organize> organizeList;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public List<Organize> getOrganizeList() {
        return organizeList;
    }

    public void setOrganizeList(List<Organize> organizeList) {
        this.organizeList = organizeList;
    }
}
