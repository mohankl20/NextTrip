package com.mohan.nexttrip.api.impl;

import com.mohan.nexttrip.DirectionsEnum;
import com.mohan.nexttrip.api.NextTripService;
import com.mohan.nexttrip.exception.BusException;
import com.mohan.nexttrip.helper.NextTripTimeHelper;
import com.mohan.nexttrip.rest.dto.RouteDTO;
import com.mohan.nexttrip.rest.dto.StopDTO;
import com.mohan.nexttrip.rest.dto.TripDepartureDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NextTripServiceImpl implements NextTripService
{
    private static final Logger logger = LoggerFactory.getLogger(NextTripServiceImpl.class);

    @Autowired
    private NextTripTimeHelper nextTripTimeHelper;

    @Override
    public String nextTripDepartureTime(String route, String stop, String dir)
    {
        logger.trace(">> nextTripDepartureTime");
        String routeId = "";
        String stopId = "";
        String nextTripDepartureTime = "";

        DirectionsEnum direction = getDirection(dir);
        routeId = getRouteId(route, routeId);
        stopId = getStopId(stop, routeId, direction);
        nextTripDepartureTime = getNextTripDepartureTime(routeId, direction, stopId);
        logger.trace("<< nextTripDepartureTime");
        return nextTripDepartureTime;
    }

    private String getNextTripDepartureTime(String routeId, DirectionsEnum direction, String stopId)
    {
        logger.trace(">> getNextTripDepartureTime");
        String nextBusDepartureTime;
        List<TripDepartureDTO> tripDepartureDTOList = nextTripTimeHelper.getNextTripDepartureTimeList(routeId,stopId,direction.getDirection());
        nextBusDepartureTime = computeNextDepartureTime(tripDepartureDTOList.get(0));
        logger.trace("<< getNextTripDepartureTime");
        return nextBusDepartureTime;

    }

    /**
     * get the stop id for a route and direction
     * @param stop
     * @param routeId
     * @param direction
     * @return
     */
    private String getStopId(String stop, String routeId, DirectionsEnum direction)
    {
        logger.trace(">> getStopId");
        String stopId = null;
        List<StopDTO> stopDTOList = nextTripTimeHelper.getRouteStopList(routeId, direction.getDirection());
        StopDTO stopDTO = stopDTOList.stream().filter(s -> s.getText().contains(stop)).findAny().orElse(null);
        if (stopDTO != null)
            stopId = stopDTO.getValue();
        logger.trace("<< getStopId");
        return stopId;
    }

    /**
     * get the route id for a given route
     * @param route
     * @param routeId
     * @return
     */
    private String getRouteId(String route, String routeId)
    {
        logger.trace(">> getRouteId");
        List<RouteDTO> routeList = nextTripTimeHelper.getRouteList();
        if (routeList != null) {
            RouteDTO routeDTO = routeList.stream()
                    .filter(r -> r.getDescription().contains(route)).
                            findAny().orElse(null);
            if (routeDTO != null)
                routeId = routeDTO.getRoute();
            else
                throw new BusException("Invalid Route");
        }
        logger.trace("<< getRouteId");
        return routeId;
    }

    /**
     * compute next departure time from trip departure
     * @param tripDepartureDTO
     * @return
     */
    private String computeNextDepartureTime(TripDepartureDTO tripDepartureDTO)
    {
        logger.trace(">> computeNextDepartureTime");
        String departureTime = tripDepartureDTO.getDepartureTime().substring(6,19);
        Long longTime = Long.valueOf(departureTime);
        Long nextBusDepartureTime = (longTime-System.currentTimeMillis())/60000;
        if(nextBusDepartureTime > 0)
            return new StringBuffer().append(nextBusDepartureTime).append(" minutes").toString();
        logger.trace("<< computeNextDepartureTime");
        return "";
    }

    /**
     * get direction enum from the input direction string
     * @param dir
     * @return
     */
    private DirectionsEnum getDirection(String dir)
    {
        logger.trace(">> getDirection");
        DirectionsEnum direction=null;
        if(dir.equalsIgnoreCase("north"))
        {
            direction = DirectionsEnum.NORTHBOUND;
        }
        else if(dir.equalsIgnoreCase("south"))
        {
            direction = DirectionsEnum.SOUTHBOUND;
        }
        else if(dir.equalsIgnoreCase("east"))
        {
            direction = DirectionsEnum.EASTBOUND;
        }
        else if (dir.equalsIgnoreCase("west"))
        {
            direction = DirectionsEnum.WESTBOUND;
        }
        else
        {
           throw new BusException("Invalid Direction");
        }
        logger.trace("<< getDirection");
        return direction;
    }
}
