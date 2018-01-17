package com.yy.dream.core.config.mysql;

public enum DataSourceType {
    DREAM1(1),
    DREAM0(0);
    public int id;

    DataSourceType(int id) {
        this.id = id;
    }

    public static DataSourceType valueOf(int id) {
        for (DataSourceType dataSourceType : DataSourceType.values()) {
            if (dataSourceType.id == id) {
                return dataSourceType;
            }
        }
        return null;
    }
}