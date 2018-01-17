package com.yy.dream.core.config.mysql;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
   @Override
   protected Object determineCurrentLookupKey() {
      return ContextHolder.getCustomerType();
   }
}