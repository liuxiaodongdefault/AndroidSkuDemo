package sku.product.com.skudemo;

import java.util.List;

/**
 * Created by liuxiaodongdefault
 * Created at 17/11/8
 * Project name SkuDemo
 * Package name sku.product.com.skudemo
 * Description 填充Recylerview的数据模型
 */

public class RvDataModel {
    private String name;
    private int type;
    private int status; //0 未选中 1 选中 2 不可用
    private int groupId;
    private List<String> groupList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }
}
