package com.springboot.demo.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.springboot.demo.model.entity.Member;
import com.springboot.demo.repository.MemberRepository;

import static org.mockito.Mockito.*;

public class MemberServiceImplTest {
  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  @InjectMocks
  private MemberServiceImpl service;

  @Mock
  private MemberRepository memberRepository;

  private Member member = Member.builder()
          .username("indraep")
          .name("Indra")
          .build();

  @After
  public void tearDown() {
    verifyNoMoreInteractions(memberRepository);
  }

  @Test
  public void findMemberFound() {
    mockFindMember(true);

    Member member = service.getMember("indraep");

    verify(memberRepository, times(1)).findOne("indraep");
    Assert.assertNotNull(member);
    Assert.assertEquals("Indra", member.getName());
    /*try {
      service.getMember("indraep");
    } catch (RuntimeException e) {
      verify(memberRepository).findOne("indraep");
    }*/
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

  @Test
  public void createMemberSuccess() {
    mockFindMember(false);
    mockSaveMember();
    Member member = service.createMember("indraep", "Indra");

    verify(memberRepository).findOne("indraep");
    verify(memberRepository).save(member);

    Assert.assertNotNull(member);
    Assert.assertEquals("indraep", member.getUsername());
    Assert.assertEquals("Indra", member.getName());
  }

  @Test
  public void createMemberFail() {
    mockFindMember(true);
    try {
      service.createMember("indraep", "Indra");
    } catch (RuntimeException e) {
      verify(memberRepository).findOne("indraep");
    }
  }

  private void mockFindMember(boolean found) {
    when(memberRepository.findOne("indraep"))
        .thenReturn(found ? member : null);
  }

  private void mockSaveMember() {
    when(memberRepository.save(member))
      .thenReturn(member);
  }

}
