package com.johndang.displaydate;

import org.springframework.stereotype.Controller;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import java.util.Date;


@Controller

public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping("/date")
    //import localdate, datetimeformatter and format like so
    //https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
    public String date(Model model) {
    	LocalDate date = LocalDate.now();
    	DateTimeFormatter theDate = DateTimeFormatter.ofPattern("EEEE, ' the' dd' of ' MMMM, YYYY");
    	
    	
    	model.addAttribute("date", date.format(theDate));
        return "date.jsp";
    }
    
    @RequestMapping("/time")
    public String time(Model model) {
    	LocalTime time = LocalTime.now();
    	DateTimeFormatter theTime = DateTimeFormatter.ofPattern("h:m:s a");
    	
    	model.addAttribute("time", time.format(theTime));
        return "time.jsp";
    }
    
    
}