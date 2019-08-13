package com.masterjavaonline.timetracker.service;

import com.masterjavaonline.timetracker.model.TrackRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


public interface EmployeeService {


    List<TrackRecord> getTrackRecords(int offset, int length);


    List<TrackRecord> getTrackRecordsByEmp(String email, int length);

    TrackRecord addEmployeTrack(String email, String frmdate, String todate);


}
