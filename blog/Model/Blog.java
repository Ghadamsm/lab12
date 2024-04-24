package com.example.blog.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    @NotEmpty(message = "please enter your title")
    @Size(min = 10 , message = "title should be more than 10 char")
    @Column(columnDefinition = "varchar(50) not null")
    private String title ;


    @NotEmpty(message = "body should be not empty")
    @Size(min = 30 , message = "body should be more than 30 char")
    @Column(columnDefinition = "varchar(300) not null")
    private String body ;



    @ManyToOne
    @JsonIgnore
    private User user ;


}
