package org.peace.todo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User extends BaseEntity{

    @Column(name = "name")
      private String name ;
    @Column(name = "username")
      private String username ;
    @Column(name = "email")
      private String email ;
    @Column(name = "password")
      private String password ;
}
