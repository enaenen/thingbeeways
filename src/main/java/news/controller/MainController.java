package com.antybeety.news.controller;

import com.antybeety.news.dao.ArticleInfoDAO;
import com.antybeety.news.vo.ArticleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ArticleInfoDAO dao;

/*    @RequestMapping(value="/fuck", method= RequestMethod.GET)
    public ModelAndView fuck(){
       List<ArticleInfoVO> article= dao.searchArticleInfo("1907190001");
       ModelAndView mav= new ModelAndView("fuck");
      // mav.addObject("article", article);

       return mav;
    }*/

    @RequestMapping(value= "/home" ,method = RequestMethod.GET)
    public ModelAndView members() {
        //List<Member> list = new dao.searchArticleInfo()
        ModelAndView mav = new ModelAndView("news");
        List<ArticleInfoVO> articles= dao.searchAllArticles();
        mav.addObject("articles", articles);
        return mav;
    }
}
