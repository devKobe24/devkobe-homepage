package com.kobe.devkobehompage.service;

import com.kobe.devkobehompage.dto.request.PostSaveRequestDto;
import com.kobe.devkobehompage.dto.response.PostResponseDto;
import com.kobe.devkobehompage.entity.Category;
import com.kobe.devkobehompage.entity.Post;
import com.kobe.devkobehompage.entity.User;
import com.kobe.devkobehompage.repository.CategoryRepository;
import com.kobe.devkobehompage.repository.PostRepository;
import com.kobe.devkobehompage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.kobe.devkobehompage.service
 * fileName       : PostService
 * author         : kobe
 * date           : 2025. 9. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 14.        kobe       최초 생성
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;

	@Transactional
	public Long save(PostSaveRequestDto requestDto) {
		// TODO: 로그인 기능 구현 후 실제 사용자로 변경해야 함
		User user = userRepository.findById(1L)
			.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID = " + 1L));

		// 2. categoryId로 Category 엔티티를 조회함.
		Category category = categoryRepository.findById(requestDto.getCategoryId())
			.orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

		Post post = requestDto.toEntity(user, category);

		return postRepository.save(post).getId();
	}

	public PostResponseDto findById(Long id) {
		Post entity = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID = " + id));
		return new PostResponseDto(entity);
	}

	public Page<PostResponseDto> findAll(Pageable pageable) {
		return postRepository.findAllDesc(pageable)
			.map(PostResponseDto::new);
	}

	public Page<PostResponseDto> findAllByCategory(Long categoryId, Pageable pageable) {
		return postRepository.findAllByCategory(categoryId, pageable)
			.map(PostResponseDto::new);
	}

	@Transactional
	public void delete(Long id) {
		Post post = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID = " + id));
		postRepository.delete(post);
	}
}
