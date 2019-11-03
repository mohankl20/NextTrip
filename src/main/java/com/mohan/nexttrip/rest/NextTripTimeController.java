package com.mohan.nexttrip.rest;

import com.mohan.nexttrip.api.NextBusService;
import com.mohan.nexttrip.helper.NextTripTimeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/nexttrip")
public class NextTripTimeController {

    private static final Logger logger = LoggerFactory.getLogger(NextTripTimeController.class);

    @Autowired
    NextBusService nextBusService;

    @Autowired
    NextTripTimeHelper nextTripTimeHelper;


    @GetMapping(value = "/{route}/{stop}/{direction}")
    public ResponseEntity<String> getNextTripWaitTime(@PathVariable(name = "route") String route, @PathVariable(name = "stop") String stop, @PathVariable(name = "direction") String direction) throws IOException
    {
        logger.trace(">> getNextTripWaitTime");
        String nextBusDepartureTime = nextBusService.nextTripDepartureTime(route, stop, direction);
        logger.trace("<< getNextTripWaitTime");
        return new ResponseEntity<>(nextBusDepartureTime, HttpStatus.OK);

    }

}
