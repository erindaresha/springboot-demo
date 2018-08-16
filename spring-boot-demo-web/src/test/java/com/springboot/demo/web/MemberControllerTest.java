package com.springboot.demo.web;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.demo.model.entity.Member;
import com.springboot.demo.service.MemberService;
import com.springboot.demo.service.TodoService;
import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class MemberControllerTest {

  @Value("${local.server.port}")
  protected int serverPort;

  @MockBean
  private MemberService memberService;

  @MockBean
  private TodoService todoService;

  @Before
  public void setUp() throws Exception {
    RestAssured.port = serverPort;
  }

  @Test
  public void getMember() {
    when(memberService.getMember("indraep"))
        .thenReturn(Member.builder().username("indraep").name("Indra").build());

    RestAssured.given()
        .get("/api/member/indraep")
        .then()
        .body("data.username", equalTo("indraep"))
        .body("data.name", equalTo("Indra"))
        .body("code", equalTo(HttpStatus.OK.value()))
        .statusCode(HttpStatus.OK.value());

    verify(memberService).getMember("indraep");
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(memberService);
  }
}
