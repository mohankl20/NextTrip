package com.mohan.nexttrip.rest.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class RouteDTO
{
    String description;

    String providerID;

    String route;

    public String getDescription() {
        return description;
    }

    @JsonSetter("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getProviderID() {
        return providerID;
    }

    @JsonSetter("ProviderID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getRoute() {
        return route;
    }

    @JsonSetter("Route")
    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString()
    {
        return "RouteDTO{" +
                "description='" + description + '\'' +
                ", providerID='" + providerID + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
