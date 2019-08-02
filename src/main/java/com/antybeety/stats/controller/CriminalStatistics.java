package com.antybeety.stats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CriminalStatistics {
    @RequestMapping("/stats.do")
    public String stats(@RequestParam (value = "crimeId")String crimeId){
        System.out.println(crimeId);

        return "stats";
    }
}
