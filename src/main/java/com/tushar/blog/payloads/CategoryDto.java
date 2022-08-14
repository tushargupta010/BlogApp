package com.tushar.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer id;
	
	@NotEmpty
	@Size(min = 4)
	private String title;
	
	@NotEmpty
	private String description;
	
	
}
