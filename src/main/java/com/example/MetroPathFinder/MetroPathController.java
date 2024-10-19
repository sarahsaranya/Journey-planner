package com.example.MetroPathFinder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Request body class for pathfinding
class PathRequest {
    private String start;
    private String end;

    // Getters and setters
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
}

// Main controller for handling metro path requests
@RestController
@RequestMapping("/api")
public class MetroPathController {

    private final Graph_M graph; // Your Graph_M class instance

    // Constructor to initialize the Graph_M instance and create the metro map
    public MetroPathController() {
        this.graph = new Graph_M();
        Graph_M.Create_Metro_Map(graph); // Populate the graph with stations and edges
    }

    // Endpoint to find the shortest path between two stations
    @PostMapping("/findPath")
    public ResponseEntity<List<String>> findPath(@RequestBody PathRequest request) {
        String startStation = request.getStart();
        String endStation = request.getEnd();

        if (!graph.containsVertex(startStation) || !graph.containsVertex(endStation)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid stations
        }

        // Call the Dijkstra algorithm to find the shortest path
        int distance = graph.dijkstra(startStation, endStation, false);

        // Check if the path was found and return appropriate response
        if (distance == Integer.MAX_VALUE) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Path not found
        }

        List<String> path = new ArrayList<>();
        // Here you can modify to get the path string from Dijkstra or any other method
        path.add("Shortest distance from " + startStation + " to " + endStation + " is: " + distance);

        return new ResponseEntity<>(path, HttpStatus.OK);
    }

    // Endpoint to get minimum distance
    @GetMapping("/minDistance")
    public ResponseEntity<String> getMinimumDistance(@RequestParam String start, @RequestParam String end) {
        String result = graph.Get_Minimum_Distance(start, end);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // Endpoint to get minimum time
    @GetMapping("/minTime")
    public ResponseEntity<String> getMinimumTime(@RequestParam String start, @RequestParam String end) {
        String result = graph.Get_Minimum_Time(start, end);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
