package com.kobe.devkobehompage.controller;

import com.kobe.devkobehompage.dto.request.CommentSaveRequestDto;
import com.kobe.devkobehompage.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.kobe.devkobehompage.controller
 * fileName       : CommentController
 * author         : kobe
 * date           : 2025. 9. 15.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 15.        kobe       최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

	private final CommentService commentService;

	@PostMapping
	public ResponseEntity<Long> saveComment(@RequestBody CommentSaveRequestDto requestDto) {
		return ResponseEntity.ok(commentService.save(requestDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
		commentService.delete(id);
		return ResponseEntity.ok().build();
	}
}
