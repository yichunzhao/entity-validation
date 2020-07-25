package com.ynz.entityautovalidation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3,max = 20,message = "Name should not less than 3 and bigger than 20")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;
}
