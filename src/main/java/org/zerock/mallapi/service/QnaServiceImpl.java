package org.zerock.mallapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.mallapi.entity.Qna;
import org.zerock.mallapi.repository.QnaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaRepository qnaRepository;

    @Override
    public List<Qna> list() {

        return qnaRepository.findAll();
    }

    @Override
    public Qna detail(Long id) {

        return qnaRepository.findById(id).orElse(null);
    }

    @Override
    public Qna create(Qna qna) {

        return qnaRepository.save(qna);
    }

    @Override
    public Qna update(Long id, Qna qna) {

        Qna oldQna = qnaRepository.findById(id).orElse(null);

        if (oldQna == null) {
            return null;
        }

        oldQna.setTitle(qna.getTitle());
        oldQna.setContent(qna.getContent());

        return qnaRepository.save(oldQna);
    }

    @Override
    public void delete(Long id) {

        qnaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void reply(Long qno, String reply) {

    Qna qna = qnaRepository.findById(qno)
            .orElseThrow(() -> new RuntimeException("QnA not found"));

    qna.setReply(reply);

    qnaRepository.save(qna);
}
}