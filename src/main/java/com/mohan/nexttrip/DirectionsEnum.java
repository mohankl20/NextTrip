package com.mohan.nexttrip;

public enum DirectionsEnum
{
SOUTHBOUND("1"),EASTBOUND("2"),WESTBOUND("3"),NORTHBOUND("4");

    String direction;
    DirectionsEnum(String direction)
    {
        this.direction=direction;
    }

    public String getDirection() {
        return direction;
    }
}
