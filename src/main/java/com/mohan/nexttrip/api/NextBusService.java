package com.mohan.nexttrip.api;

public interface NextBusService
{
    /**
     * get the next departure time for a given route,stop and direction.
     * @param route
     * @param stop
     * @param direction
     * @return
     */
    String nextTripDepartureTime(String route, String stop, String direction);
}
