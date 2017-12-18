package com.yy.dream.core.db;

/**
 * Created by Administrator on 2017/12/16.
 */
public class ShardBean {


    public int getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(Long uid) {
        this.tableSuffix =(int)(uid%2);
    }

    int tableSuffix;
    public int getDatabaseSuffix(Long uid){
        return (int)(uid%2);
    };
}
