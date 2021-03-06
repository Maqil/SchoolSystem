package com.school.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer professorAiid;
    private String fullName;
    private String email;
    private String phone;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private Set<Subject> subjects;

    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Set<Todo> todos;

    @ManyToOne
    private Admin admin;
}
