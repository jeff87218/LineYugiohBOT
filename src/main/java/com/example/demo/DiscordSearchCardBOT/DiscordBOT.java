package com.example.demo.DiscordSearchCardBOT;

import com.example.demo.DemoApplication;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;


@Service
public class DiscordBOT {

    @Value("${tokens.discord}")
    String TOKEN;
    public String prefix;
    @Autowired
    MessageListener messageListener;
    JDABuilder BOT;

    public JDA RunDiscordBOT() {
        BOT = JDABuilder.createDefault(TOKEN);
        prefix = "!";
        BOT.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        BOT.setBulkDeleteSplittingEnabled(false);
        BOT.setCompression(Compression.NONE);
        BOT.setActivity(Activity.playing("決鬥!"));
        BOT.enableIntents(GatewayIntent.GUILD_MEMBERS);
        registerListener();
        JDA jda = null;
        try {
            jda = BOT.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        return jda;
    }

    public void registerListener() {
        BOT.addEventListeners(messageListener);
    }
}
