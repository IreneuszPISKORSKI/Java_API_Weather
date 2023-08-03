package com.example.irek_api_java_weather;

public class BusListModel {
    private String name;

    public BusListModel(String name) {
        this.name = name;
    }

    public BusListModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BusStop name: '" + name + '\'';
    }
}
