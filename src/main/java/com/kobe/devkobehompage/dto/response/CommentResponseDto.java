package com.kobe.devkobehompage.dto.response;

import com.kobe.devkobehompage.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.kobe.devkobehompage.dto.response
 * fileName       : CommentResponseDto
 * author         : kobe
 * date           : 2025. 9. 15.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 15.        kobe       최초 생성
 */
@Getter
public class CommentResponseDto {
	private final Long id;
	private final String content;
	private final String author;
	private final LocalDateTime createdAt;

	public CommentResponseDto(Comment comment) {
		this.id = comment.getId();
		this.content = comment.getContent();
		this.author = comment.getUser().getUsername();
		this.createdAt = comment.getCreatedAt();
	}
}
