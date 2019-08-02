package com.antybeety.news.mybatis;

import com.antybeety.news.vo.ArticleInfoVO;

import java.util.List;
import java.util.Map;


public interface ArticleMapper {
    List<ArticleInfoVO> searchArticleInfo(String code);
    List<ArticleInfoVO> searchAllArticles();

    int deleteMember(String test_id);
    int updateMember(Map<String, Object> map);
    String searchArticleTimeByCode(String code);
    List<ArticleInfoVO> searchBeforeArticlesByTime(String time, int limit);
}
