package com.example.demo.DiscordSearchCardBOT;

import com.example.demo.SearchForCards.YGOCARD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/vi/DiscordBOTRun")
public class ActiveDiscordBOT {

    @GetMapping
    @ResponseBody
    public String ResponseCardJson(){
        DiscordBOT.RunDiscordBOT();
        return "ok";
    }
}


