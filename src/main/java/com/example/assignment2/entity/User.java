package com.example.assignment2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name="User")
public class User {
    @Id
    private Long id;
    private String name;
}
