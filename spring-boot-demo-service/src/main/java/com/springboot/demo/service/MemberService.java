package com.springboot.demo.service;

import com.springboot.demo.model.entity.Member;

public interface MemberService {

  Member createMember(String username, String name);

  Member findMember(String username);

}
