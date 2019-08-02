package com.antybeety.news.controller;

import com.antybeety.news.dao.ArticleInfoDAO;
import com.antybeety.news.vo.ArticleInfoVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewsController {

    private Log logger = LogFactory.getLog(MainController.class);
    @Autowired
    private ArticleInfoDAO dao;

    @RequestMapping(value="/signup",method=RequestMethod.GET)
    public String signup(){
        return "/news/register";
    }

/*    @RequestMapping(value="/signup",method = RequestMethod.POST) //회원가입 할 때때
   public String signupProc(@RequestParam(value="id")String id,
                            @RequestParam(value="pwd")String pwd,
                            @RequestParam(value = "name")String name){
        Member newMember = new Member(id,pwd,name);
        newMember.setMem_type(0);

        dao.addMember(newMember);
        return "redirect:/tables";
    }*/

    public String handleException(NullPointerException ex){
        logger.error(ex.getMessage());

        return "/error/page";
    }



    @RequestMapping(value="/register",method = RequestMethod.GET) //회원가입 할 때때
    public String signupProc(){
        logger.info("called home method");
        return "/news/register";
    }


    @RequestMapping(value="/tables", method= RequestMethod.GET)
    public ModelAndView tables() {
        ModelAndView mav = new ModelAndView("/news/tables");
        List<ArticleInfoVO> articles= dao.searchAllArticles();
        mav.addObject("articles", articles);
        return mav;
    }
}
