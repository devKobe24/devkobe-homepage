package com.kobe.devkobehompage.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.kobe.devkobehompage.entity
 * fileName       : Category
 * author         : kobe
 * date           : 2025. 9. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 14.        kobe       최초 생성
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false, length = 100)
	private String name;

	private String description;

	private String color;

	private int displayOrder;

	@Builder
	public Category(String name, String description, String color, int displayOrder) {
		this.name = name;
		this.description = description;
		this.color = color;
		this.displayOrder = displayOrder;
	}
}
