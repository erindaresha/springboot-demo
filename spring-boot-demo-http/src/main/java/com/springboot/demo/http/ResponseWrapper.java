package com.springboot.demo.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {

  private Integer code;
  private String message;
  private T value;

}
