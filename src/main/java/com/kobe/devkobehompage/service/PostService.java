package com.kobe.devkobehompage.service;

import com.kobe.devkobehompage.dto.request.PostSaveRequestDto;
import com.kobe.devkobehompage.dto.response.PostResponseDto;
import com.kobe.devkobehompage.entity.Post;
import com.kobe.devkobehompage.entity.User;
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

	@Transactional
	public Long save(PostSaveRequestDto requestDto) {
		// 임시로 첫 번째 사용자를 작성자로 설정 (향후 인증 기능 추가 시 변경)
		User user = userRepository.findById(1L)
			.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ID = " + 1L));
		return postRepository.save(requestDto.toEntity(user)).getId();
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
