package com.mycompany.bs.bookservice.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {
	
	private Integer id;
	private String title;
	private String author;
	private Instant publishDate;
	private Integer count;

}
