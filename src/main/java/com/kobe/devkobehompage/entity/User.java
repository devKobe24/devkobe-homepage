package com.kobe.devkobehompage.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.kobe.devkobehompage.entity
 * fileName       : User
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
@Table(name = "users")
public class User extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false, length = 50)
	private String username;

	@Column(unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserRole role;

	@Lob
	private String bio;
	private String profileImageUrl;
	private String githubUrl;
	private String linkedInUrl;
	private String instagramUrl;

	@Builder
	public User(String username,
	            String email,
	            String passwordHash,
	            UserRole role,
	            String bio,
	            String profileImageUrl,
	            String githubUrl,
	            String linkedInUrl,
	            String instagramUrl
	) {
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
		this.role = role;
		this.bio = bio;
		this.profileImageUrl = profileImageUrl;
		this.githubUrl = githubUrl;
		this.linkedInUrl = linkedInUrl;
		this.instagramUrl = instagramUrl;
	}

	public void updateProfile(String bio, String profileImageUrl, String githubUrl, String linkedInUrl, String instagramUrl) {
		this.bio = bio;
		this.profileImageUrl = profileImageUrl;
		this.githubUrl = githubUrl;
		this.linkedInUrl = linkedInUrl;
		this.instagramUrl = instagramUrl;
	}
}
