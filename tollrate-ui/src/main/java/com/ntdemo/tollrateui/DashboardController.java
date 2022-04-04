package com.ntdemo.tollrateui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class DashboardController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/rate")
    public String getRate(@RequestParam(defaultValue = "1000") Integer stationId, Model m){
        TollRate rate = webClientBuilder.build().get()
                .uri("http://tollrate-service/tollrate/"+stationId)
                .retrieve()
                .bodyToMono(TollRate.class)
                .block();
        System.out.println("Station Id:" + stationId);
        m.addAttribute("rate",rate);
        return "dashboard";

    }

}
