package org.zerock.mallapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.mallapi.entity.Qna;
import org.zerock.mallapi.repository.QnaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaRepository repo;

    @Override
    public List<Qna> list() {
        return repo.findAll();
    }

    @Override
    public Qna detail(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("QNA not found"));
    }

    @Override
    public Qna create(Qna qna) {
        return repo.save(qna);
    }

    @Override
    public Qna update(Long id, Qna qna) {
        Qna db = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("QNA not found"));

        db.setTitle(qna.getTitle());
        db.setContent(qna.getContent());
        db.setWriter(qna.getWriter());

        return repo.save(db);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
