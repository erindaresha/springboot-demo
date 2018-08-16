package com.springboot.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import com.springboot.demo.model.entity.Member;
import com.springboot.demo.service.MemberService;
import io.swagger.annotations.Api;

@Api(value = "Member Controller")
@RestController
public class MemberController {

  @Autowired
  private MemberService memberService;

  @PostMapping("/api/member")
  public Response<Member> createMember(@RequestParam String username, @RequestParam String name) {
    return ResponseHelper.ok(memberService.createMember(username, name));
  }

  @GetMapping("/api/member/{username}")
  public Response<Member> getMember(@PathVariable String username) {
    return ResponseHelper.ok(memberService.getMember(username));
  }

}
