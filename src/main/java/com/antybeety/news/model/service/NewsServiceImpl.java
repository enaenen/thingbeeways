package com.antybeety.news.model.service;

import com.antybeety.news.model.dao.ArticleInfoDAO;
import com.antybeety.news.model.vo.ArticleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private ArticleInfoDAO dao;

    public NewsServiceImpl() {
    }


    public List<ArticleInfoVO> getMoreArticles(String lastArticleCode, int limit) {
        if (lastArticleCode == null || lastArticleCode.equals("")) {
            System.out.println("기사 코드 오류");
            return null;
        }

        if (limit <= 0) {
            limit = 5;
        }

        String time = dao.searchArticleTimeByCode(lastArticleCode);
        List<ArticleInfoVO> list = dao.searchBeforeArticlesByTime(time, limit);

        return list;
    }

    public List<ArticleInfoVO> initializeArticle(int limit) {

        if (limit <= 0) {
            limit = 5;
        }

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(date);
        List<ArticleInfoVO> list = dao.searchBeforeArticlesByTime(date, limit);
        return list;
    }

    public List<ArticleInfoVO> searchArticles(String searchWord, String lastArtiCode, String lastDate, String district, int cnt) {

        String startTime;
        if (lastArtiCode.equals("")) {    //원래 있던 기사 코드가 존재하지 않을 경우 -> 현재시간을 시작 시간으로 설정
            startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        } else {    //원래 있던 기사 코드가 존재할 경우 -> 마지막 기사를 시작 시간으로 설정
            startTime = dao.searchArticleTimeByCode(lastArtiCode);
        }

        if (lastDate.equals("")) {        //마지막 시간이 존재하지 않을 경우 -> 마지막 시간 필터 사용X
            lastDate = "1990-00-00 00:00:00";
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cal.add(Calendar.DATE, Integer.parseInt(lastDate) * -1);
            lastDate = df.format(cal.getTime());
        }
        List<ArticleInfoVO> res = dao.searchArticleByFilter(searchWord, startTime, lastDate, district, cnt);

        return res;
    }


    public List<ArticleInfoVO> searchArticles(String searchWord, String lastArtiCode, String lastDate, int cnt) {

        String startTime;
        if (lastArtiCode.equals("")) {    //원래 있던 기사 코드가 존재하지 않을 경우 -> 현재시간을 시작 시간으로 설정
            startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        } else {    //원래 있던 기사 코드가 존재할 경우 -> 마지막 기사를 시작 시간으로 설정
            startTime = dao.searchArticleTimeByCode(lastArtiCode);
        }

        if (lastDate.equals("")) {        //마지막 시간이 존재하지 않을 경우 -> 마지막 시간 필터 사용X
            lastDate = "1990-00-00 00:00:00";
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cal.add(Calendar.DATE, Integer.parseInt(lastDate) * -1);
            lastDate = df.format(cal.getTime());
        }
        List<ArticleInfoVO> res = dao.searchArticleByFilter(searchWord, startTime, lastDate, cnt);

        return res;
    }


}