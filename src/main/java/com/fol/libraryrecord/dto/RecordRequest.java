package com.fol.libraryrecord.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@Schema(description = "It represents a record of books taken from the library and returned")
public class RecordRequest {

    @Schema(description = "ID of user that took/returned the book.")
    private Long userId;

    @Schema(description = "The name of the book associated with the library record.")
    private String bookTitle;

    @Schema(description = "The authors of the book associated with the library record.")
    private String author;

    @Schema(description = "Publication date of the book associated with the library record.")
    private Date publicationDate;

    @Schema(description = "Availability status of the book")
    private String bookStatus;

    @Schema(description = "Date ant time when the book is taken")
    private Timestamp checkoutTimestamp;

    @Schema(description = "Date ant time when the book is returned")
    private Timestamp returnTimestamp;

}
