package com.kobe.devkobehompage.service;

import com.kobe.devkobehompage.dto.request.CommentSaveRequestDto;
import com.kobe.devkobehompage.entity.Comment;
import com.kobe.devkobehompage.entity.Post;
import com.kobe.devkobehompage.entity.User;
import com.kobe.devkobehompage.repository.CommentRepository;
import com.kobe.devkobehompage.repository.PostRepository;
import com.kobe.devkobehompage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.kobe.devkobehompage.service
 * fileName       : CommentService
 * author         : kobe
 * date           : 2025. 9. 15.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 15.        kobe       최초 생성
 */
@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final PostRepository postRepository;
	private final UserRepository userRepository;

	@Transactional
	public Long save(CommentSaveRequestDto requestDto) {
		Post post = postRepository.findById(requestDto.getPostId())
			.orElseThrow(() -> new IllegalArgumentException("Invalid post ID"));
		// TODO: Replace with actual logged-in user logic
		User user = userRepository.findById(1L)
			.orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

		Comment comment = Comment.builder()
			.content(requestDto.getContent())
			.post(post)
			.user(user)
			.build();

		return commentRepository.save(comment).getId();
	}

	@Transactional
	public void delete(Long commentId) {
		commentRepository.deleteById(commentId);
	}
}
