package com.siemens.ifa.activityplanner.api;

import com.siemens.ifa.activityplanner.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivitiesController {

    @Autowired
    private TestService testService;

    //http:///localhost:8080/test
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public ResponseEntity test() {
        return ResponseEntity
                .status(200)
                .body(testService.message());
    }
}
