package com.antybeety.news.model.dao;

import com.antybeety.news.mybatis.NewsMapper;
import com.antybeety.news.model.vo.ArticleInfoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ArticleInfoDAOImpl implements ArticleInfoDAO{


    @Autowired
    private SqlSession sqlSession;

    public ArticleInfoDAOImpl() {

    }

    public List<ArticleInfoVO> searchAllArticles() {
        NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
        List<ArticleInfoVO> info = mapper.searchAllArticles();
        return info;
    }

    public List<ArticleInfoVO> searchArticleInfo(String code) {

        NewsMapper mapper =sqlSession.getMapper(NewsMapper.class);
        List<ArticleInfoVO>  info = mapper.searchArticleInfo(code);
        return info;
    }

    public String searchArticleTimeByCode(String code) {
        NewsMapper mapper =sqlSession.getMapper(NewsMapper.class);
        String time = mapper.searchArticleTimeByCode(code);
        return time;
    }

    public List<ArticleInfoVO> searchBeforeArticlesByTime(String time, int limit) {
        NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
        HashMap<String,Object> param = new HashMap<String,Object>();
        param.put("time", time);
        param.put("limit",limit);
        List<ArticleInfoVO> articles = mapper.searchBeforeArticlesByTime(param);
        return articles;
    }

    public List<ArticleInfoVO> searchArticleByFilter(String searchWord, String startTime, String lastTime, int limit) {
        NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
        HashMap<String,Object> param = new HashMap<String,Object>();
        param.put("searchWord", searchWord);
        param.put("startTime", startTime);
        param.put("lastTime",lastTime);
        param.put("limit",limit);
        List<ArticleInfoVO> articles = mapper.searchArticleByFilter(param);
        return articles;
    }

    public List<ArticleInfoVO> searchArticleByFilter(String searchWord, String startTime, String lastTime, String district, int limit) {
        NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
        HashMap<String,Object> param = new HashMap<String,Object>();
        param.put("searchWord", searchWord);
        param.put("startTime", startTime);
        param.put("lastTime",lastTime);
        param.put("district", district);
        param.put("limit",limit);
        List<ArticleInfoVO> articles =mapper.searchArticleByFilterDistrict(param);
        return articles;
    }
}
