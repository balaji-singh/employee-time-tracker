package com.masterjavaonline.timetracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;

public interface EmployeeBaseController extends BaseController {

    @RequestMapping(value = {"/byrange"}, method = RequestMethod.POST)
    public ModelAndView getTrackRecords(ModelAndView modelAndView, @RequestParam(name = "offset", required = true) int offset,
                                        @RequestParam(name = "length", required = true) int length) throws MalformedURLException;


    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public ModelAndView addEmployeTrack(ModelAndView modelAndView, @RequestParam(name = "email") String email,
                                        @RequestParam(name = "frmdate") String frmdate, @RequestParam(name = "todate") String todate);

    @RequestMapping(value = {"/byemp"}, method = RequestMethod.POST)
    public ModelAndView getTrackRecordsByEmp(ModelAndView modelAndView, @RequestParam(name = "email", required = true) String email,
                                             @RequestParam(name = "length", required = true) int length);




    }
