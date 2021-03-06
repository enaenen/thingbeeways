package com.antybeety.news.mybatis;

import com.antybeety.news.model.vo.ArticleInfoVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface NewsMapper {

//    int addArticle(ArticleInfoVO article);
    List<ArticleInfoVO> searchArticleInfo(String code);
    List<ArticleInfoVO> searchAllArticles();
    String searchArticleTimeByCode(String code);
    List<ArticleInfoVO> searchBeforeArticlesByTime(HashMap<String, Object> param);
    List<ArticleInfoVO> searchArticleByFilter(HashMap<String, Object> param);
    List<ArticleInfoVO> searchArticleByFilterDistrict(HashMap<String, Object> param);
//    int updateArticle(ArticleInfoVO oldArticle, ArticleInfoVO newArticle);
//    int removeArticle(String code);

}
