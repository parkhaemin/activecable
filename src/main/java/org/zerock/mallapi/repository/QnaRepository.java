package org.zerock.mallapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.mallapi.entity.Qna;

public interface QnaRepository extends JpaRepository<Qna, Long> {
}