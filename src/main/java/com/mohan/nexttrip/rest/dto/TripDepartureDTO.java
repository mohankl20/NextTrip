package com.mohan.nexttrip.rest.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class TripDepartureDTO
{
    String actual;
    Integer blockNumber;
    String departureText;
    String departureTime;
    String description;
    String gate;
    String route;
    String routeDirection;
    String terminal;
    Integer vehicleHeading;
    Integer vehicleLatitude;
    Integer vehicleLongitude;

    public String getActual() {
        return actual;
    }

    @JsonSetter("Actual")
    public void setActual(String actual) {
        this.actual = actual;
    }

    public Integer getBlockNumber() {
        return blockNumber;
    }

    @JsonSetter("BlockNumber")
    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getDepartureText() {
        return departureText;
    }

    @JsonSetter("DepartureText")
    public void setDepartureText(String departureText) {
        this.departureText = departureText;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @JsonSetter("DepartureTime")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDescription() {
        return description;
    }
    @JsonSetter("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getGate() {
        return gate;
    }
    @JsonSetter("Gate")
    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getRoute() {
        return route;
    }
    @JsonSetter("Route")
    public void setRoute(String route) {
        this.route = route;
    }

    public String getRouteDirection() {
        return routeDirection;
    }
    @JsonSetter("RouteDirection")
    public void setRouteDirection(String routeDirection) {
        this.routeDirection = routeDirection;
    }

    public String getTerminal() {
        return terminal;
    }
    @JsonSetter("Terminal")
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Integer getVehicleHeading() {
        return vehicleHeading;
    }
    @JsonSetter("VehicleHeading")
    public void setVehicleHeading(Integer vehicleHeading) {
        this.vehicleHeading = vehicleHeading;
    }

    public Integer getVehicleLatitude() {
        return vehicleLatitude;
    }
    @JsonSetter("VehicleLatitude")
    public void setVehicleLatitude(Integer vehicleLatitude) {
        this.vehicleLatitude = vehicleLatitude;
    }

    public Integer getVehicleLongitude() {
        return vehicleLongitude;
    }
    @JsonSetter("VehicleLongitude")
    public void setVehicleLongitude(Integer vehicleLongitude) {
        this.vehicleLongitude = vehicleLongitude;
    }

    @Override
    public String toString()
    {
        return "TripDepartureDTO{" +
                "actual='" + actual + '\'' +
                ", blockNumber=" + blockNumber +
                ", departureText='" + departureText + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", description='" + description + '\'' +
                ", gate='" + gate + '\'' +
                ", route='" + route + '\'' +
                ", routeDirection='" + routeDirection + '\'' +
                ", terminal='" + terminal + '\'' +
                ", vehicleHeading=" + vehicleHeading +
                ", vehicleLatitude=" + vehicleLatitude +
                ", vehicleLongitude=" + vehicleLongitude +
                '}';
    }
}
