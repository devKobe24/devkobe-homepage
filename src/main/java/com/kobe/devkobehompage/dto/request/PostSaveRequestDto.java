package com.kobe.devkobehompage.dto.request;

import com.kobe.devkobehompage.entity.Category;
import com.kobe.devkobehompage.entity.Post;
import com.kobe.devkobehompage.entity.PostStatus;
import com.kobe.devkobehompage.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName    : com.kobe.devkobehompage.dto
 * fileName       : PostSaveRequestDto
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
public class PostSaveRequestDto {
	private String title;
	private String content;
	private Long categoryId;
	private PostStatus status;

	public Post toEntity(User user, Category category) {
		return Post.builder()
			.title(title)
			.content(content)
			.category(category)
			.status(status)
			.user(user)
			.build();
	}
}
