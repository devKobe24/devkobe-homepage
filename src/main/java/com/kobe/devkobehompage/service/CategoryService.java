package com.kobe.devkobehompage.service;

import com.kobe.devkobehompage.dto.CategoryDto;
import com.kobe.devkobehompage.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName    : com.kobe.devkobehompage.service
 * fileName       : CategoryService
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
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public List<CategoryDto> findAll() {
		return categoryRepository.findAll().stream()
			.map(CategoryDto::new)
			.collect(Collectors.toList());
	}
}
