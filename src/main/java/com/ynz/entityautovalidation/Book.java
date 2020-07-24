package com.ynz.entityautovalidation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;

    @Version
    private Long version;

    @NotNull(message = "Book must has a title.")
    @Size(min = 5, max = 20, message = "Title length should between 5 and 20.")
    private String title;

    @NotNull(message = "Book must has a publishing date.")
    @Temporal(TemporalType.DATE)
    private Date publishingDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime = new Date();
}
