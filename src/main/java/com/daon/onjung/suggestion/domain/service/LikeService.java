package com.daon.onjung.suggestion.domain.service;

import com.daon.onjung.account.domain.User;
import com.daon.onjung.suggestion.domain.mysql.Board;
import com.daon.onjung.suggestion.domain.mysql.Like;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    public Like createLike(
            User user,
            Board board
    ) {
        return Like.builder()
                .user(user)
                .board(board)
                .build();
    }
}
