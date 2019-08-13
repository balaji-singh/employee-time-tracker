package com.masterjavaonline.timetracker.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.masterjavaonline.timetracker.model.TrackRecord;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Value("${app.protocal}")
    private String protocal;

    @Value("${app.mapping}")
    private String mapping;

    @Value("${app.port}")
    private String port;

    @Value("${app.host}")
    private String host;

    @Override
    public List<TrackRecord> getTrackRecords(int offset, int length) {

        RestTemplate restTemplate = new RestTemplate();


        String endpoint = protocal + "://" + host + ":" + port + "/" + mapping;
        logger.info("endpoint", endpoint);
        String jsonData = restTemplate.getForObject(endpoint + "?offset=" + offset + "&length=" + length, String.class);

        System.out.println(jsonData);
        List<TrackRecord> trackRecords = new ArrayList<>();
        trackRecords= new Gson()
                .fromJson(jsonData, new TypeToken<ArrayList<TrackRecord>>() {
                }.getType());
        return trackRecords;

    }

    @Override
    public List<TrackRecord> getTrackRecordsByEmp(String email, int length) {

        RestTemplate restTemplate = new RestTemplate();
        String endpoint = protocal + "://" + host + ":" + port + "/" + mapping;
        String jsonData = restTemplate.getForObject(endpoint + "?email=" + email + "&length=" + length, String.class);

        System.out.println(jsonData);
        List<TrackRecord> trackRecords = new ArrayList<>();
        trackRecords = new Gson()
                .fromJson(jsonData, new TypeToken<ArrayList<TrackRecord>>() {
                }.getType());

        trackRecords.removeAll(Collections.singletonList(null));

        return trackRecords;
    }

    @Override
    public TrackRecord addEmployeTrack(String email, String frmdate, String todate) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

        Date from = null;
        Date to = null;
        try {
            from = (Date) formatter.parse(frmdate);
            to = (Date) formatter.parse(todate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String pattern = "dd.MM.yyyy hh:mm a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String fromDate = simpleDateFormat.format(from);
        String toDate = simpleDateFormat.format(to);


        System.out.println("Form date" + frmdate);
        String endpoint = protocal + "://" + host + ":" + port + "/" + mapping;
        String url = endpoint + "?end=" + toDate + "&start=" + fromDate + "&email=" + email;
        url = url.replace(" ", "%20");
        System.out.println("URL:" + url);


        Client client = Client.create();

        WebResource webResource = client
                .resource(url);
        String input = "{}";
        ClientResponse response = webResource.type("application/json")
                .post(ClientResponse.class, input);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        System.out.println("Output from Server .... \n");
        String jsonStr = response.getEntity(String.class);
        System.out.println(jsonStr);
        TrackRecord trackRecord = new Gson()
                .fromJson(jsonStr, new TypeToken<TrackRecord>() {
                }.getType());

        return trackRecord;
    }
}
