package org.peace.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{


    @Column(name = "title")
    private String title ;
    @Column(name = "description")
    private String description ;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

}
