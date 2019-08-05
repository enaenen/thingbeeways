package com.antybeety.news.mybatis;

import com.antybeety.news.model.vo.ArticleInfoVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface NewsMapper {
    List<ArticleInfoVO> searchArticleInfo(String code);
    List<ArticleInfoVO> searchAllArticles();

    int deleteMember(String test_id);
    int updateMember(Map<String, Object> map);
    String searchArticleTimeByCode(String code);
    List<ArticleInfoVO> searchBeforeArticlesByTime(HashMap<String, Object> param);
    List<ArticleInfoVO> searchArticleByFilter(HashMap<String, Object> param);
    List<ArticleInfoVO> searchArticleByFilterDistrict(HashMap<String, Object> param);
}
