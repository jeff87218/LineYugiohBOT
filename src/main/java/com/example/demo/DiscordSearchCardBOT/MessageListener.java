package com.example.demo.DiscordSearchCardBOT;

import com.example.demo.SearchForCards.YGOCARD;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.sql.Time;
import java.util.ArrayList;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class MessageListener extends ListenerAdapter {

    private DiscordBOT discordBOT;
    private YGOCARD ygocard;

    @Autowired
    public MessageListener(DiscordBOT discordBOT, YGOCARD ygocard) {
        this.discordBOT = discordBOT;
        this.ygocard = ygocard;
    }

    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (message.equalsIgnoreCase(discordBOT.prefix + "help") && !event.getMessage().getAuthor().isBot()) {
            event.getChannel().sendMessage("輸入~Card 卡號/卡名 即可查詢卡片").queue();
        }
        if (message.contains(discordBOT.prefix + "查卡 ") && !event.getMessage().getAuthor().isBot()) {
            String CardInfo = ygocard.SearchCard(message.replace(discordBOT.prefix + "查卡 ", ""));
            if (CardInfo.length() >= 2000) {
                event.getChannel().sendMessage("結果太多，無法顯示").queue();
            } else {
                try {
                    event.getChannel().sendMessage(CardInfo).queue();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
