package com.springboot.demo.http.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Connection {

  private Long connectTimeout = 10 * 1000L;

  private Long readTimeout = 10 * 1000L;

  private Long writeTimeout = 10 * 1000L;

  private Integer maxIdleConnections = 5;

  private Long keepAliveDurationNs = 5 * 60 * 1000L;

  private Boolean retryOnConnectionFailure = true;

}
