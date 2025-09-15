package com.kobe.devkobehompage.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName    : com.kobe.devkobehompage.dto.request
 * fileName       : CommentSaveRequest
 * author         : kobe
 * date           : 2025. 9. 15.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 15.        kobe       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
public class CommentSaveRequestDto {
	private Long postId;
	private String content;
}
