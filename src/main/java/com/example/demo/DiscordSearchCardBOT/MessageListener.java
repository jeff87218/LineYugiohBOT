package com.example.demo.DiscordSearchCardBOT;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;


public class MessageListener extends ListenerAdapter {


    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event){
        String message = event.getMessage().getContentRaw();
        if(message.equalsIgnoreCase(DiscordBOT.prefix+"help")){
            event.getChannel().sendMessage("輸入~Card 卡號/卡名 即可查詢卡片").queue();
        }
        if(message.contains(DiscordBOT.prefix+"查卡 ")){

            DiscordFindCard discordFindCard = new DiscordFindCard();
            String CardInfo = discordFindCard.FindCard(message.replace(DiscordBOT.prefix+"查卡 ",""));
            event.getChannel().sendMessage(CardInfo).queue();

        }
    }
}
