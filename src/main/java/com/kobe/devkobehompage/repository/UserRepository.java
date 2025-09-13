package com.kobe.devkobehompage.repository;

import com.kobe.devkobehompage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.kobe.devkobehompage.repository
 * fileName       : UserRepository
 * author         : kobe
 * date           : 2025. 9. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 14.        kobe       최초 생성
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
