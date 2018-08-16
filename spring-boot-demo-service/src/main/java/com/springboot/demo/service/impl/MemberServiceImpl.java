package com.springboot.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.entity.Member;
import com.springboot.demo.repository.MemberRepository;
import com.springboot.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public Member createMember(String username, String name) {
    if (memberRepository.findOne(username) != null) {
      throw new RuntimeException("Member already existed");
    }

    return memberRepository.save(Member.builder().username(username).name(name).build());
  }

  @Override
  public Member getMember(String username) {
    Member member = memberRepository.findOne(username);

    if (member == null) {
      throw new RuntimeException("Member not found");
    } else {
      return member;
    }
  }

}
