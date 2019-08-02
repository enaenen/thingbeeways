package com.antybeety;


import com.antybeety.stats.model.dao.CrimeStatsDAO;
import com.antybeety.stats.model.vo.CrimeStatsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "file:web/WEB-INF/dispatcher-servlet.xml",
        "file:web/WEB-INF/mybatis-config.xml"
})
@WebAppConfiguration
public class MyBatisTest {
    @Autowired
    private CrimeStatsDAO dao;
    @Test
    public void testing(){
        List<CrimeStatsVO> list=dao.searchStatsListByYear(2017);
        assertNotNull("list는 null이면 안됩니다.",list);
        System.out.println(list);
        assertFalse("검색 결과 없음",list.isEmpty());
    }
    @Test
    public void testing2(){
        List<CrimeStatsVO> list=dao.searchStatsListByYearCategory(2017,"폭력");
        assertNotNull("list는 null이면 안됩니다.",list);
        System.out.println(list);
        assertFalse("검색 결과 없음",list.isEmpty());
    }
}
