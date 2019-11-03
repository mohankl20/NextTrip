package com.mohan.nexttrip.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohan.nexttrip.rest.dto.RouteDTO;
import com.mohan.nexttrip.rest.dto.StopDTO;
import com.mohan.nexttrip.rest.dto.TripDepartureDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NextTripTimeHelper
{

    private static final Logger logger = LoggerFactory.getLogger(NextTripTimeHelper.class);

    @Autowired
    protected RestTemplate restTemplate;

    @Value("${service.protocol:https}")
    protected String serviceProtocol;

    @Value("${service.host:}")
    protected String serviceHost;

    ObjectMapper objectMapper = new Jackson2ObjectMapperBuilder().build();;

    /**
     * get the next trip time schedules
     * @param routeId
     * @param stopId
     * @param directionId
     * @return
     */
    public List<TripDepartureDTO> getNextTripDepartureTimeList(String routeId, String stopId, String directionId)
    {
        logger.trace(">> getNextTripDepartureTimeList");
        List<TripDepartureDTO> responseList = new ArrayList<>();
        String url = serviceProtocol+"://"+serviceHost+"/NexTrip/"+routeId+"/"+directionId+"/"+stopId;
        ResponseEntity<List<TripDepartureDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null,timePointDepartureAPIParameterizedTypeReference);
        if (response.getStatusCode() == HttpStatus.OK)
            responseList = response.getBody();
        logger.trace("<< getNextTripDepartureTimeList");
        return responseList;
    }

    /**
     * get the route list
     * @return
     */
    public List<RouteDTO> getRouteList()
    {
        logger.trace(">> getRouteList");
        List<RouteDTO> responseList = new ArrayList<>();
        String url = serviceProtocol+"://"+serviceHost+"/NexTrip/Routes";
        ResponseEntity<List<RouteDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null, routeAPIParameterizedTypeReference);
        if (response.getStatusCode() == HttpStatus.OK)
            responseList= response.getBody();
        logger.trace("<< getRouteList");
        return responseList;
    }

    /**
     * get the stop list for a route id and direction
     * @param routeId
     * @param direction
     * @return
     */
    public List<StopDTO> getRouteStopList(String routeId,String direction)
    {
        logger.trace(">> getRouteStopList");
        List<StopDTO> responseList = new ArrayList<>();
        String url = serviceProtocol + "://" + serviceHost + "/NexTrip/Stops/" + routeId + "/" + direction;
        ResponseEntity<List<StopDTO>> response = restTemplate.exchange(url, HttpMethod.GET, null, stopAPIParameterizedTypeReference);
        if (response.getStatusCode() == HttpStatus.OK)
            responseList = response.getBody();
        logger.trace("<< getRouteStopList");
        return responseList;
    }


    private final ParameterizedTypeReference<List<StopDTO>> stopAPIParameterizedTypeReference = new ParameterizedTypeReference<List<StopDTO>>()
    {
    };

    private final ParameterizedTypeReference<List<RouteDTO>> routeAPIParameterizedTypeReference = new ParameterizedTypeReference<List<RouteDTO>>()
    {
    };
    private final ParameterizedTypeReference<List<TripDepartureDTO>> timePointDepartureAPIParameterizedTypeReference = new ParameterizedTypeReference<List<TripDepartureDTO>>()
    {
    };

}
