package com.fol.libraryrecord.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "library_record")
public class LibraryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;

    @Column(name = "book_status", nullable = false)
    private String bookStatus;

    @Column(name = "checkout_timestamp")
    private Timestamp checkoutTimestamp;

    @Column(name = "return_timestamp")
    private Timestamp returnTimestamp;

}
