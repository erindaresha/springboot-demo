package com.springboot.demo.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")
public class Todo {

  @Id
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_username", referencedColumnName = "username")
  private Member member;

  private String title;

  private String description;

}
