package com.kobe.devkobehompage.dto.resoponse;

import com.kobe.devkobehompage.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.kobe.devkobehompage.dto.resoponse
 * fileName       : PostResponseDto
 * author         : kobe
 * date           : 2025. 9. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 14.        kobe       최초 생성
 */
@Getter
public class PostResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public PostResponseDto(Post entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getUser().getUsername();
		this.createdAt = entity.getCreatedAt();
		this.updatedAt = entity.getUpdatedAt();
	}
}
