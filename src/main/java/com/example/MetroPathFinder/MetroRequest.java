package com.example.MetroPathFinder;

public class MetroRequest {
    private String start;
    private String end;

    // Default constructor (required for Spring to bind the JSON data)
    public MetroRequest() {
    }

    // Parameterized constructor for easy initialization (optional)
    public MetroRequest(String start, String end) {
        this.start = start;
        this.end = end;
    }

    // Getter and Setter methods
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "MetroRequest{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
