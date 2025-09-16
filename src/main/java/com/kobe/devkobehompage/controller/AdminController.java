package com.kobe.devkobehompage.controller;

import com.kobe.devkobehompage.dto.CategoryDto;
import com.kobe.devkobehompage.dto.UserDto;
import com.kobe.devkobehompage.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.kobe.devkobehompage.controller
 * fileName       : AdminController
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
@RequestMapping("/admin")
public class AdminController {

	private final AdminService adminService;

	@GetMapping
	public String adminDashboard(Model model) {
		model.addAttribute("posts", adminService.findAllPosts());
		model.addAttribute("categories", adminService.findAllCategories());
		model.addAttribute("comments", adminService.findAllComments());
		model.addAttribute("userProfile", adminService.findUserById(1L));
		return "admin/index";
	}

	@PostMapping("/categories")
	public String createCategory(@ModelAttribute CategoryDto categoryDto) {
		adminService.saveCategory(categoryDto);
		return "redirect:/admin";
	}

	@PostMapping("/categories/delete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		adminService.deleteCategory(id);
		return "redirect:/admin";
	}

	@PostMapping("/profile/update")
	public String updateProfile(@ModelAttribute UserDto userDto) {
		// TODO: 현재는 기본 사용자 ID(1)를 사용하고 있으나, 추후 인증된 사용자 정보로 대체해야 합니다.
		adminService.updateUserProfile(1L, userDto);
		return "redirect:/admin";
	}
}
