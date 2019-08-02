package com.antybeety.news.dao;

import com.antybeety.news.vo.ArticleInfoVO;

import java.util.List;


public interface ArticleInfoDAO {

    List<ArticleInfoVO> searchArticleInfo(String code);
    List<ArticleInfoVO> searchAllArticles();
    String searchArticleTimeByCode(String code);
    List<ArticleInfoVO> searchBeforeArticlesByTime(String time, int limit);







/*    int removeMember(String test_id);
    int modifyMember(Map<String, Object> map)*/

}
