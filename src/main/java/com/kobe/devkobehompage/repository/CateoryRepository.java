package com.kobe.devkobehompage.repository;

import com.kobe.devkobehompage.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.kobe.devkobehompage.repository
 * fileName       : CateoryRepository
 * author         : kobe
 * date           : 2025. 9. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 14.        kobe       최초 생성
 */
public interface CateoryRepository extends JpaRepository<Category, Long> {
}
