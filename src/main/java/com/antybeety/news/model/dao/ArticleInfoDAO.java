package com.antybeety.news.model.dao;

import com.antybeety.news.model.vo.ArticleInfoVO;


import java.util.HashMap;
import java.util.List;


public interface ArticleInfoDAO {

    int addArticle(ArticleInfoVO article);
    List<ArticleInfoVO> searchArticleInfo(String code);
    List<ArticleInfoVO> searchAllArticles();
    String searchArticleTimeByCode(String code);
    List<ArticleInfoVO> searchBeforeArticlesByTime(String time, int limit);
    List<ArticleInfoVO> searchArticleByFilter(String searchWord, String startTime, String lastTime, int limit);
    List<ArticleInfoVO> searchArticleByFilter(String searchWord, String startTime, String lastTime, String district, int limit);
    int updateArticle(ArticleInfoVO oldArticle, ArticleInfoVO newArticle);
    int removeArticle(String code);

}
