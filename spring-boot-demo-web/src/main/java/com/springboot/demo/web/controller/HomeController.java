package com.springboot.demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import io.swagger.annotations.Api;

@Api
@RestController
public class HomeController {

  @GetMapping("/home")
  public Response<Boolean> home() {
    return ResponseHelper.ok(true);
  }

}
