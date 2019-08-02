package com.antybeety.news.dao;
import com.antybeety.news.mybatis.ArticleMapper;
import com.antybeety.news.vo.ArticleInfoVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleInfoDAOImpl implements ArticleInfoDAO {

    public List<ArticleInfoVO> searchAllArticles() {
        ArticleMapper mapper =sqlSession.getMapper(ArticleMapper.class);
        List<ArticleInfoVO>  info = mapper.searchAllArticles();
        return info;
    }

/*    public int removeMember(String test_id) {
        return 0;
    }

    public int modifyMember(Map<String, Object> map) {
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

        return mapper.updateMember(map);
        return 0;
    }*/

    @Autowired
	private SqlSession sqlSession;

	public ArticleInfoDAOImpl() {
	}

	public List<ArticleInfoVO> searchArticleInfo(String code) {

		ArticleMapper mapper =sqlSession.getMapper(ArticleMapper.class);
		List<ArticleInfoVO>  info = mapper.searchArticleInfo(code);
		return info;
	}

    public String searchArticleTimeByCode(String code) {
        ArticleMapper mapper =sqlSession.getMapper(ArticleMapper.class);
        String time = mapper.searchArticleTimeByCode(code);
        return time;
    }

    public List<ArticleInfoVO> searchBeforeArticlesByTime(String time, int limit) {
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        List<ArticleInfoVO> articles = mapper.searchBeforeArticlesByTime(time, limit);
        return articles;
    }
}
