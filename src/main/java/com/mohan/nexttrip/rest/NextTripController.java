package com.mohan.nexttrip.rest;

import com.mohan.nexttrip.api.NextTripService;
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

@RestController
@RequestMapping("/api/nexttrip")
public class NextTripController {

    private static final Logger logger = LoggerFactory.getLogger(NextTripController.class);

    @Autowired
    private NextTripService nextTripService;

    @Autowired
    NextTripTimeHelper nextTripTimeHelper;


    @GetMapping(value = "/{route}/{stop}/{direction}")
    public ResponseEntity<String> getNextTripDepartureTime(@PathVariable(name = "route") String route, @PathVariable(name = "stop")
                                                            String stop, @PathVariable(name = "direction") String direction)
    {
        logger.trace(">> getNextTripDepartureTime");
        String nextBusDepartureTime = nextTripService.nextTripDepartureTime(route, stop, direction);
        logger.trace("<< getNextTripDepartureTime");
        return new ResponseEntity<>(nextBusDepartureTime, HttpStatus.OK);

    }

}
