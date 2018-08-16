package com.springboot.demo.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.springboot.demo.model.entity.Member;
import com.springboot.demo.repository.MemberRepository;

public class MemberServiceImplTest {

  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  @InjectMocks
  private MemberServiceImpl service;

  @Mock
  private MemberRepository memberRepository;

  @After
  public void tearDown() {
    verifyNoMoreInteractions(memberRepository);
  }

  @Test
  public void findMemberFound() {
    mockFindMember(false);

    try {
      service.getMember("indraep");
    } catch (RuntimeException e) {
      verify(memberRepository).findOne("indraep");
    }
  }

  @Test
  public void findMemberNotFound() {
    mockFindMember(false);

    try {
      service.getMember("indraep");
    } catch (RuntimeException e) {
      verify(memberRepository).findOne("indraep");
    }
  }

  private void mockFindMember(boolean found) {
    Member member = Member.builder()
        .username("indraep")
        .name("Indra")
        .build();

    when(memberRepository.findOne("indraep"))
        .thenReturn(found ? member : null);
  }

}
