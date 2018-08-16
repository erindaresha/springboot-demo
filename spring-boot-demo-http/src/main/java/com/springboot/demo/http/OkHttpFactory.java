package com.springboot.demo.http;

import java.util.concurrent.TimeUnit;

import com.springboot.demo.http.configuration.Connection;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

public class OkHttpFactory {

  public static OkHttpClient create(Connection connection) {
    return new OkHttpClient.Builder()
        .connectTimeout(connection.getConnectTimeout(), TimeUnit.MILLISECONDS)
        .writeTimeout(connection.getWriteTimeout(), TimeUnit.MILLISECONDS)
        .readTimeout(connection.getReadTimeout(), TimeUnit.MILLISECONDS)
        .connectionPool(new ConnectionPool(
            connection.getMaxIdleConnections(),
            connection.getKeepAliveDurationNs(), TimeUnit.MILLISECONDS
        ))
        .retryOnConnectionFailure(connection.getRetryOnConnectionFailure())
        .build();
  }

}
