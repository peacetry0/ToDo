package org.peace.todo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@MappedSuperclass
@Data
public abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",insertable = false,updatable = false,columnDefinition = "uuid default gen_random_uuid()")
    private UUID id ;
}
