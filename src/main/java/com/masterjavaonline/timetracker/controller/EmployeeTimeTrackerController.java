package com.masterjavaonline.timetracker.controller;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.masterjavaonline.timetracker.model.TrackRecord;
import com.masterjavaonline.timetracker.service.EmployeeService;
import com.masterjavaonline.timetracker.service.EmployeeServiceImpl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class EmployeeTimeTrackerController implements EmployeeBaseController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeTimeTrackerController.class);


    @Autowired
    EmployeeServiceImpl eMployeeService;


    @Override
    public ModelAndView getTrackRecords(ModelAndView modelAndView, @RequestParam(name = "offset", required = true) int offset, @RequestParam(name = "length", required = true) int length) {

        List<TrackRecord> trackRecords = eMployeeService.getTrackRecords(offset, length);
        logger.debug("TrackRecords from Response", trackRecords);
        modelAndView.addObject("trackRecords", trackRecords);
        modelAndView.setViewName("byrange");

        return modelAndView;
    }


    @Override
    public ModelAndView getTrackRecordsByEmp(ModelAndView modelAndView, @RequestParam(name = "email", required = true) String email, @RequestParam(name = "length", required = true) int length) {

        List<TrackRecord> trackRecords = eMployeeService.getTrackRecordsByEmp(email, length);
        logger.debug("TrackRecords from Response", trackRecords);
        modelAndView.addObject("trackRecords", trackRecords);
        modelAndView.setViewName("byemp");

        return modelAndView;

    }


    @Override
    public ModelAndView addEmployeTrack(ModelAndView modelAndView, @RequestParam(name = "email") String email,
                                        @RequestParam(name = "frmdate") String frmdate, @RequestParam(name = "todate") String todate) {
        TrackRecord trackRecord = eMployeeService.addEmployeTrack(email, frmdate, todate);
        logger.debug("TrackRecord from Response", trackRecord);
        modelAndView.addObject("message", "Track record for Emp ID:" + trackRecord.getEmail() + " Added Successfully");
        modelAndView.setViewName("add");

        return modelAndView;

    }

    @RequestMapping("/")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }

}
