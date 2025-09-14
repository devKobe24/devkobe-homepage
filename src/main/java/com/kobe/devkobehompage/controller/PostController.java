package com.kobe.devkobehompage.controller;

import com.kobe.devkobehompage.dto.request.PostSaveRequestDto;
import com.kobe.devkobehompage.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * packageName    : com.kobe.devkobehompage.controller
 * fileName       : PostController
 * author         : kobe
 * date           : 2025. 9. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 14.        kobe       최초 생성
 */
@Controller
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", postService.findAllDesc());
		return "index";
	}

	@GetMapping("/posts/{id}")
	public String postDetail(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.findById(id));
		return "post-detail";
	}

	@GetMapping("/posts/save")
	public String postSaveForm() {
		return "post-save";
	}

	@PostMapping("/posts")
	public String savePost(PostSaveRequestDto requestDto) {
		postService.save(requestDto);
		return "redirect:/";
	}

	@PostMapping("/posts/delete/{id}")
	public String deletePost(@PathVariable Long id) {
		postService.delete(id);
		return "redirect:/";
	}
}
