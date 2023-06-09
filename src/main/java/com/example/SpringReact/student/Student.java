package com.example.SpringReact.student;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(name="student_sequence",
  sequenceName = "student_sequence",
  allocationSize = 1)
  @GeneratedValue(
    generator = "student_sequence",
    strategy = GenerationType.SEQUENCE)
  private Long id;
  @NotBlank
  @Column(nullable = false)
  private String name;
  @Email
  @Column(nullable = false,unique = true)
  private String email;
  @NotNull
  @Enumerated(EnumType.STRING)
  private Gender gender;
}
