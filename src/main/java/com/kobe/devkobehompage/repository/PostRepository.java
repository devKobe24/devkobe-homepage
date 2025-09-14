package com.kobe.devkobehompage.repository;

import com.kobe.devkobehompage.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
	@Query(value = "SELECT p FROM Post p JOIN FETCH p.user",
	countQuery = "SELECT count(p) FROM Post p")
	Page<Post> findAllDesc(Pageable pageable);

	@Query(value = "SELECT p FROM Post p JOIN FETCH p.user WHERE p.category.id = :categoryId",
	countQuery = "SELECT count(p) FROM Post p WHERE p.category.id = :categoryId")
	Page<Post> findAllByCategory(@Param("categoryId") Long categoryId, Pageable pageable);
}
