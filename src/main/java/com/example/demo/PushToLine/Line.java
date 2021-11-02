package com.example.demo.PushToLine;

import com.example.demo.LinePushMessageEntity.PushMessage;
import com.example.demo.LinePushMessageEntity.SendPushData;
import com.example.demo.LineWebHook;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

//將訊息推給LINE的類別
@Component
public class Line {
    public void PushToLine(String toline, String lineid) {
        String lineurl = "https://api.line.me/v2/bot/message/push";
        Client httpclient = ClientBuilder.newClient();
        WebTarget target = httpclient.target(lineurl);
        List<PushMessage> pushMsg = new ArrayList<>();
        PushMessage pMsg = new PushMessage();
        pMsg.setType("text");
        pMsg.setText(toline);
        SendPushData pushData = new SendPushData();
        pushMsg.add(pMsg);
        pushData.setTo(lineid);
        pushData.setMessages(pushMsg);
        Gson gson = new Gson();
        String PushDataJson = gson.toJson(pushData);
        target.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, LineWebHook.Token).post(Entity.entity(PushDataJson, MediaType.APPLICATION_JSON));
    }
}
