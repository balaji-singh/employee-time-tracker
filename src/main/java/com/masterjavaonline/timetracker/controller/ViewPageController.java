package com.masterjavaonline.timetracker.controller;


import com.masterjavaonline.timetracker.model.TrackRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ViewPageController {

    @RequestMapping(value= {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView showHomePage(ModelAndView modelAndView){

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value= {"/add"}, method = RequestMethod.GET)
    public ModelAndView showAddTracker(ModelAndView modelAndView){

        modelAndView.setViewName("add");

        return modelAndView;
    }

    @RequestMapping(value= {"/byrange"}, method = RequestMethod.GET)
    public ModelAndView showTrackerRangePage(ModelAndView modelAndView){

        modelAndView.setViewName("byrange");

        return modelAndView;
    }

    @RequestMapping(value= {"/byemp"}, method = RequestMethod.GET)
    public ModelAndView showTrackByEmpPage(ModelAndView modelAndView){


        modelAndView.setViewName("byemp");

        return modelAndView;
    }
}
