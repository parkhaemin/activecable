package org.zerock.mallapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.mallapi.entity.Qna;
import org.zerock.mallapi.service.QnaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/qna")
@CrossOrigin(origins = "http://localhost:3000")
public class QnaController {

    private final QnaService qnaService;

    // 목록
    @GetMapping
    public List<Qna> list() {
        return qnaService.list();
    }

    // 상세
    @GetMapping("/{id}")
    public Qna detail(@PathVariable Long id) {
        return qnaService.detail(id);
    }

    // 등록
    @PostMapping
    public Qna create(@RequestBody Qna qna) {
        return qnaService.create(qna);
    }

    // 수정
    @PutMapping("/{id}")
    public Qna update(@PathVariable Long id,
                      @RequestBody Qna qna) {
        return qnaService.update(id, qna);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        qnaService.delete(id);
    }
}