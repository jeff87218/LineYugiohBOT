package com.example.demo.DiscordSearchCardBOT;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/vi/DiscordBOTRun")
public class ActiveDiscordBOT{

    @Autowired
    DiscordBOT discordBOT;


    @GetMapping
    @ResponseBody
    public String DiscordBOTRun() {
        discordBOT.RunDiscordBOT();
        return "ok";
    }


}


