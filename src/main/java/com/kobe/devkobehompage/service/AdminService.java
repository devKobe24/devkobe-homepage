package com.kobe.devkobehompage.service;

import com.kobe.devkobehompage.dto.CategoryDto;
import com.kobe.devkobehompage.dto.response.CommentResponseDto;
import com.kobe.devkobehompage.dto.response.PostResponseDto;
import com.kobe.devkobehompage.entity.Category;
import com.kobe.devkobehompage.repository.CategoryRepository;
import com.kobe.devkobehompage.repository.CommentRepository;
import com.kobe.devkobehompage.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.kobe.devkobehompage.service
 * fileName       : AdminService
 * author         : kobe
 * date           : 2025. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 16.        kobe       최초 생성
 */
@Service
@RequiredArgsConstructor
public class AdminService {

	private final PostRepository postRepository;
	private final CategoryRepository categoryRepository;
	private final CommentRepository commentRepository;

	@Transactional(readOnly = true)
	public List<PostResponseDto> findAllPosts() {
		return postRepository.findAll().stream()
			.map(PostResponseDto::new)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<CategoryDto> findAllCategories() {
		return categoryRepository.findAll().stream()
			.map(CategoryDto::from)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<CommentResponseDto> findAllComments() {
		return commentRepository.findAll().stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());
	}

	@Transactional
	public void saveCategory(CategoryDto dto) {
		Category category = Category.builder()
			.name(dto.getName())
			.description(dto.getDescription())
			.color(dto.getColor())
			.displayOrder(dto.getDisplayOrder())
			.build();
		categoryRepository.save(category);
	}

	@Transactional
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
