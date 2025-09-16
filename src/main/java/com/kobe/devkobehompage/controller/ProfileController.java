package com.kobe.devkobehompage.controller;

import com.kobe.devkobehompage.dto.UserDto;
import com.kobe.devkobehompage.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : com.kobe.devkobehompage.controller
 * fileName       : ProfileController
 * author         : kobe
 * date           : 2025. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 16.        kobe       최초 생성
 */
@Controller
@RequiredArgsConstructor
public class ProfileController {

	private final AdminService adminService;

	@GetMapping("/about")
	public String aboutPage(Model model) {
		// TODO: 현재는 기본 사용자 ID(1)를 사용하고 있으나, 추후 인증된 사용자 정보로 대체해야 합니다.
		UserDto userProfile = adminService.findUserById(1L);
		model.addAttribute("user", userProfile);
		return "about";
	}
}
