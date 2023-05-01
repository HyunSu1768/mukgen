package com.example.mukgen.domain.like.service;

import com.example.mukgen.domain.board.entity.Board;
import com.example.mukgen.domain.board.repository.BoardRepository;
import com.example.mukgen.domain.board.service.exception.BoardNotFoundException;
import com.example.mukgen.domain.like.controller.dto.request.LikeCreateRequest;
import com.example.mukgen.domain.like.entity.Likes;
import com.example.mukgen.domain.like.repository.LikeRepository;
import com.example.mukgen.domain.user.entity.User;
import com.example.mukgen.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LikeService {

    private final UserFacade userFacade;

    private final LikeRepository likeRepository;

    private final BoardRepository boardRepository;

    @Transactional
    public void clickLike(LikeCreateRequest request){

        User curUser = userFacade.currentUser();
        Board board = boardRepository.findById(request.getBoardId())
                .orElseThrow(()-> BoardNotFoundException.EXCEPTION);
        if(likeRepository.existsByBoardAndUserName(board,curUser.getName())){
            board.removeLike();
            likeRepository.removeByBoardAndUserName(board,curUser.getName());
        }
        else{
            Likes like = new Likes(board,curUser.getName());
            likeRepository.save(like);
            board.addLike();
        }
    }
}