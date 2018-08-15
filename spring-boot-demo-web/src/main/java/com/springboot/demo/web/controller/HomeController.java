package com.springboot.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import com.springboot.demo.repository.MemberRepository;
import io.swagger.annotations.Api;

@Api
@RestController
public class HomeController {

  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/home")
  public Response<Boolean> home() {
    return ResponseHelper.ok(true);
  }

}
