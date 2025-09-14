package com.kobe.devkobehompage.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.kobe.devkobehompage.entity
 * fileName       : Post
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
@Table(name = "posts")
public class Post extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 200)
	private String title;

	@Lob // For Long text content
	@Column
	private String content;

	@Enumerated(EnumType.STRING)
	private PostStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Builder
	public Post(String title, String content, PostStatus status, Category category, User user) {
		this.title = title;
		this.content = content;
		this.status = status;
		this.category = category;
		this.user = user;
	}
}
