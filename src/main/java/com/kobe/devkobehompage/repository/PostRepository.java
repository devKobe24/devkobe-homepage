package com.kobe.devkobehompage.repository;

import com.kobe.devkobehompage.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
	/**
	 * 모든 게시글을 ID 내림차순으로 조회합니다. (최신순)
	 * 'JOIN FETCH p.user'를 사용하여 게시글을 조회할 때 연관된 User 엔티티 함께 조회합니다.
	 * 이를 통해 게시글 목록에서 작성자 이름을 표시할 때 발생하는 N+1 문제를 예방할 수 있습니다.
	 *
	 * @return ID를 기준으로 내림차순 정렬된 Post 리스트
	 */
	@Query("SELECT p FROM Post p JOIN FETCH p.user ORDER BY p.id DESC")
	List<Post> findAllDesc();
}
