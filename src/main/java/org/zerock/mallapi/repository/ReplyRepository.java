package org.zerock.mallapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.mallapi.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByQna_IdOrderByIdAsc(Long qnaId);

}
