package main.java.model.service;

import main.java.model.like.LikeDAO;

import java.sql.SQLException;

public class LikeService {

    LikeDAO likeDAO = new LikeDAO();

    public void clickLike(String email, int beanNum) throws SQLException {
        if(checkLike(email,beanNum)){
            likeDAO.insertLike(email,beanNum);

        }
        else likeDAO.deleteLike(email, beanNum);

    }

    //이미 좋아요 -> false , 좋아요X -> TRUE
    public boolean checkLike(String email, int beanNum) throws SQLException {
        return likeDAO.checkLike(email, beanNum);
    }

    //내가 찜한 목록 불러오기

}
