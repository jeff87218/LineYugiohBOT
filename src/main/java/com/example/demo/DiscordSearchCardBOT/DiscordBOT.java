package com.example.demo.DiscordSearchCardBOT;

import com.example.demo.DiscordSearchCardBOT.MessageListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class DiscordBOT {
     static String TOKEN="";
     static JDABuilder BOT = JDABuilder.createDefault(TOKEN);
     static public String prefix;

     public static void RunDiscordBOT() {
        prefix="!";
        BOT.disableCache(CacheFlag.MEMBER_OVERRIDES,CacheFlag.VOICE_STATE);
        BOT.setBulkDeleteSplittingEnabled(false);
        BOT.setCompression(Compression.NONE);
        BOT.setActivity(Activity.playing("決鬥!"));
        BOT.enableIntents(GatewayIntent.GUILD_MEMBERS);
        registerListener();
        try {
            BOT.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
     public static void registerListener(){
        BOT.addEventListeners(new MessageListener());
    }
}
