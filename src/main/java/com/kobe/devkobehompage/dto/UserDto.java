package com.kobe.devkobehompage.dto;

import com.kobe.devkobehompage.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName    : com.kobe.devkobehompage.dto
 * fileName       : UserDto
 * author         : kobe
 * date           : 2025. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 16.        kobe       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	private Long id;
	private String username;
	private String email;
	private String bio;
	private String profileImageUrl;
	private String githubUrl;
	private String linkedInUrl;
	private String instagramUrl;

	public static UserDto from(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setBio(user.getBio());
		dto.setProfileImageUrl(user.getProfileImageUrl());
		dto.setGithubUrl(user.getGithubUrl());
		dto.setLinkedInUrl(user.getLinkedInUrl());
		dto.setInstagramUrl(user.getInstagramUrl());
		return dto;
	}
}
