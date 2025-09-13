package com.kobe.devkobehompage.repository;

import com.kobe.devkobehompage.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.kobe.devkobehompage.repository
 * fileName       : PostRepository
 * author         : kobe
 * date           : 2025. 9. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 14.        kobe       최초 생성
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
