package com.springboot.demo.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.demo.RepositoryConfiguration;
import com.springboot.demo.model.entity.Member;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @Before
  public void setUp() {
    memberRepository.deleteAll();
  }

  @Test
  public void testSave() {
    Member member = Member.builder()
        .username("indraep")
        .name("Indra")
        .build();

    memberRepository.save(member);

    assertEquals(1, memberRepository.count());
  }

}
