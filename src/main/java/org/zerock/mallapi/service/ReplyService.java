package org.zerock.mallapi.service;

import java.util.List;

import org.zerock.mallapi.entity.Reply;

public interface ReplyService {

    Reply save(Long qnaId, String content);

    List<Reply> list(Long qnaId);

    void delete(Long replyId);

    Reply update(Long replyId, String content);
}
