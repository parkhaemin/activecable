package org.zerock.mallapi.service;

import java.util.List;

import org.zerock.mallapi.entity.Qna;

public interface QnaService {

    List<Qna> list();

    Qna detail(Long id);   // ⭐ 추가

    Qna create(Qna qna);

    Qna update(Long id, Qna qna);

    void delete(Long id);
}
