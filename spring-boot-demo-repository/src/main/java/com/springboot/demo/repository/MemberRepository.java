package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {}
