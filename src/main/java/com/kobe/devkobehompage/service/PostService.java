package com.kobe.devkobehompage.service;

import com.kobe.devkobehompage.repository.PostRepository;
import lombok.RequiredArgsConstructor;
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

	// TODO: Phase 2에서 CRUD 메서드 구현 예정
}
