package com.ntdemo.tollrateservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TollRateController {
    List<TollRate> tollrates;

    public TollRateController() {
        tollrates=new ArrayList<TollRate>();
        tollrates.add(new TollRate(1000,0.55f, Instant.now().toString()));
        tollrates.add(new TollRate(1001,0.05f, Instant.now().toString()));
        tollrates.add(new TollRate(1002,0.60f, Instant.now().toString()));
        tollrates.add(new TollRate(1003,1.00f, Instant.now().toString()));
    }

    @RequestMapping("/tollrate/{stationId}")
    public TollRate getToll(@PathVariable int stationId){
        System.out.println("Station Requested:"+stationId);
        return tollrates.stream().filter(rate -> stationId==rate.getStationId()).findAny().get();
    }
}
