package com.example.demo.Controller;


import com.example.demo.Entitys.LineEntity.WebHookEventData;
import com.example.demo.Service.PushToLineService;
import com.example.demo.Service.CardSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//與LineWebHook連接的類別

@RestController
@RequestMapping(path = "api/vi/YgoBot")
public class LineWebHookController {
    private String lineid = "";
    public static String Token;
    private CardSearchService cardSearchService;
    private PushToLineService pushToLineService;

    //LineToken
    @Value("${tokens.line}")
    public void setAccessToken(String LineToken) {
        Token = LineToken;
    }


    @Autowired
    public LineWebHookController(CardSearchService cardSearchService, PushToLineService pushToLineService) {
        this.cardSearchService = cardSearchService;
        this.pushToLineService = pushToLineService;
    }

    @PostMapping
    public void GetLineMsg(@RequestBody WebHookEventData data) {
        String usermsg = null;
        lineid = data.getEvents().get(0).getSource().getUserId(); //取出line user id
        if (data.getEvents().get(0).getMessage().getType().equals("text")) {
            usermsg = data.getEvents().get(0).getMessage().getText();
        }
        if (usermsg != null) {
            String CardInfo = cardSearchService.SearchCard(usermsg);
            if (CardInfo != null) {
                //Response to Line
                pushToLineService.PushToLine(CardInfo, lineid);
            }
        }
    }
}

