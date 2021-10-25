package com.example.demo.DiscordSearchCardBOT;

import com.example.demo.SearchForCards.YGOCARD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/YgoCardAPI")
public class SearchCardApiForDiscord {
    @Autowired
    YGOCARD ygocard;

    @GetMapping
    @ResponseBody
    public String ResponseCardJson(@RequestParam("Card") String keyword){
        return ygocard.SearchCard(keyword);
    }
}
