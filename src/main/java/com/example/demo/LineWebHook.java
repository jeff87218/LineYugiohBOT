package com.example.demo;


import com.example.demo.DiscordSearchCardBOT.DiscordBOT;
import com.example.demo.LineEntity.WebHookEventData;

import com.example.demo.PushToLine.Line;
import com.example.demo.SearchForCards.YGOCARD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


//與LineWebHook連接的類別

@RestController
@RequestMapping(path = "api/vi/YgoBot")
public class LineWebHook {
    private String lineid = "";
    public static final String AccessToken = "";
    private YGOCARD ygocard;
    private Line line;



    @Autowired
    public LineWebHook(YGOCARD ygocard, Line line) {
        this.ygocard = ygocard;
        this.line = line;
    }

    @PostMapping
    public void GetLineMsg(@RequestBody WebHookEventData data) throws IOException {
        String usermsg = null;
        lineid = data.getEvents().get(0).getSource().getUserId(); //取出line user id
        if (data.getEvents().get(0).getMessage().getType().equals("text")) {
            usermsg = data.getEvents().get(0).getMessage().getText();
        }
        if (usermsg != null) {
            String CardInfo = ygocard.SearchCard(usermsg);
            //Response to Line
            line.PushToLine(CardInfo,lineid);
        }
    }
}

