package com.kobe.devkobehompage.dto;

import com.kobe.devkobehompage.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Setter
@NoArgsConstructor
public class CategoryDto {
	private Long id;
	private String name;
	private String description;
	private String color;
	private int displayOrder;

	@Builder
	public CategoryDto(Long id, String name, String description, String color, int displayOrder) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.color = color;
		this.displayOrder = displayOrder;
	}

	public static CategoryDto from(Category category) {
		return CategoryDto.builder()
			.id(category.getId())
			.name(category.getName())
			.description(category.getDescription())
			.color(category.getColor())
			.displayOrder(category.getDisplayOrder())
			.build();

	}
}
