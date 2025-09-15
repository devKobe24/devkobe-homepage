package com.kobe.devkobehompage.repository;

import com.kobe.devkobehompage.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.kobe.devkobehompage.repository
 * fileName       : CommentRepository
 * author         : kobe
 * date           : 2025. 9. 15.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 15.        kobe       최초 생성
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
