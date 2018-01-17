package com.yy.dream.core.config.mysql;

import org.springframework.util.Assert;

public class ContextHolder {

   private static final ThreadLocal<DataSourceType> contextHolder =
            new ThreadLocal<DataSourceType>();

    public static void setDataSourceByUid(Long uid) {
        DataSourceType dataSourceType=DataSourceType.valueOf((int)(uid%2));
        Assert.notNull(dataSourceType, "dataSourceType cannot be null");
        contextHolder.set(dataSourceType);
   }

   public static DataSourceType getCustomerType() {
      return (DataSourceType) contextHolder.get();
   }

   public static void clearCustomerType() {
      contextHolder.remove();
   }
}