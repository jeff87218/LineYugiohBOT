package com.example.demo.DiscordSearchCardBOT;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class DiscordFindCard {
    public String FindCard(String keyword){
        String lineurl = "";
        try {
            lineurl = String.format("https://ygobotcardsearcher.azurewebsites.net/api/vi/YgoCardAPI?Card=%s", URLEncoder.encode(keyword,"UTF-8"));
            //Encding 輸出
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(lineurl);
        Client httpclient = ClientBuilder.newClient();
        WebTarget target = httpclient.target(lineurl);
        Invocation.Builder builder = target.request();
        Response response = builder.get();

        return response.readEntity(String.class);
    }
}
