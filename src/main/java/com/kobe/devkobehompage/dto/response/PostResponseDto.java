package com.kobe.devkobehompage.dto.response;

import com.kobe.devkobehompage.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.kobe.devkobehompage.dto.response
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

	private final List<CommentResponseDto> comments;

	public PostResponseDto(Post entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getUser().getUsername();
		this.createdAt = entity.getCreatedAt();
		this.updatedAt = entity.getUpdatedAt();
		this.comments = entity.getComments().stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());
	}
}
