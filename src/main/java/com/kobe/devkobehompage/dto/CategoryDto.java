package com.kobe.devkobehompage.dto;

import com.kobe.devkobehompage.entity.Category;
import lombok.Getter;

/**
 * packageName    : com.kobe.devkobehompage.dto
 * fileName       : CategoryDto
 * author         : kobe
 * date           : 2025. 9. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 14.        kobe       최초 생성
 */
@Getter
public class CategoryDto {
	private final Long id;
	private final String name;

	public CategoryDto(Category entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
}
