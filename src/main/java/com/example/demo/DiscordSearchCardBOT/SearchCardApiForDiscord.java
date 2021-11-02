package com.example.demo.DiscordSearchCardBOT;

import com.example.demo.SearchForCards.YGOCARD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SearchCardApiForDiscord {
    @Autowired
    YGOCARD ygocard;

    @GetMapping(path = "api/vi/YgoCardAPI")
    @ResponseBody
    public String ResponseCardJson(@RequestParam("Card") String keyword){
        String cardinfo = ygocard.SearchCard(keyword);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cardinfo;
    }

    @GetMapping(path = "api/vi/ForCheckOnly")
    @ResponseBody
    public String ForCheckOnly(){
        return "OK";
    }
}
