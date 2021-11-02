package com.example.demo.SearchForCards;

import com.example.demo.YgoCardEntity.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public class YGOCARD {
    private DataRepository GetYgoDatas;
    private TextRepository GetYgoTexts;
    private TypeprefixRepository GetYgoType;

    @Autowired
    public YGOCARD(DataRepository getYgoDatas, TextRepository getYgoTexts, TypeprefixRepository getYgoType) {
        GetYgoDatas = getYgoDatas;
        GetYgoTexts = getYgoTexts;
        GetYgoType = getYgoType;
    }

    public String SearchCard(String ID)  {
        //檢查是否為數字 如果不是則改為卡名尋找
        try {
            Integer.parseInt(ID);
        }catch (NumberFormatException exception){
            return ID.isBlank()?null:this.SearchCardByName(ID);
        }
        List<Data> carddatas;
        List<Text> cardtexts;
        List<Typeprefix> cardtype;

        carddatas = GetYgoDatas.findById(Integer.parseInt(ID));
        cardtexts = GetYgoTexts.findById(Integer.parseInt(ID));
        cardtype = GetYgoType.findBytype(carddatas.get(0).getType());
        if(cardtexts.size()==0){
            return null;
        }
        String CardName = cardtexts.get(0).getName();
        String CardATK = carddatas.get(0).getAtk().toString();
        String CardDef = carddatas.get(0).getDef().toString();
        String CardDesc = cardtexts.get(0).getDesc();
        CardATK = Integer.parseInt(CardATK)==-2?"?":CardATK;
        CardDef = Integer.parseInt(CardDef)==-2?"?":CardDef;
        StringBuilder CardInfo = new StringBuilder();
        return cardtype.get(0).getIsmagicortrap()?
                CardInfo.append("卡名:" + CardName +"\n卡片類型:"+cardtype.get(0).getChinesetype() +"\n\n效果:\n"+cardtexts.get(0).getDesc()).toString()
                :CardInfo.append("卡名:" + CardName + "\n卡片類型:"+cardtype.get(0).getChinesetype() + "\n\n效果:\n" + CardDesc+"\n\n攻擊力:"+CardATK+"/守備力:"+CardDef).toString();
    }
    //以卡名查卡
     private String SearchCardByName(String KeyWord) {
        Gson gson = new Gson();
        List<Text> cardtextsOG = new ArrayList<>(GetYgoTexts.findByNameLike(KeyWord));
        String cardtextJSON = gson.toJson(cardtextsOG);
        List<Text> cardtextsFIXED = gson.fromJson(cardtextJSON,new TypeToken<List<Text>>(){}.getType());
        StringBuilder CardInfo = new StringBuilder();

        if(cardtextsOG.size()==0){
            return null;
        }
        //把相同卡名不同密碼的卡片進行過濾
        int CardTextSize = cardtextsFIXED.size();
        for(int x=0;x<CardTextSize;x++){
            for(int z=1;z<CardTextSize;z++){
                if(cardtextsFIXED.get(x).getName().equals(cardtextsFIXED.get(z).getName())){
                    cardtextsFIXED.remove(z);
                    CardTextSize = cardtextsFIXED.size();
                }
            }
        }
        //如果搜尋結果大於2張卡則改用清單顯示
        if(cardtextsFIXED.size()>=2){
            CardInfo.append("名子帶有:\""+KeyWord+"\"的卡片有\n");
            for(int i=0;i<cardtextsOG.size();i++){
                CardInfo.append("密碼:"+cardtextsOG.get(i).getId()+"\n卡名:"+cardtextsOG.get(i).getName()+"\n-------------\n");
            }
            return CardInfo.toString();
        }else{
            //如果卡名搜尋出來的結果只有一張卡，則直接取得卡片密碼，並改用密碼尋找
            return this.SearchCard(cardtextsFIXED.get(0).getId().toString());
        }
    }
    //圖片找卡，未完成!TODO
//    public String SearchByImage(String MessageID) {
//        List<Data> carddatas;
//        carddatas = GetYgoDatas.findAll();
//        File img0 = getCardImage.CardImageFromLine(MessageID);
//        for(int i=0;i<carddatas.size();i++) {
//            File img1;
//            try {
//                 img1 = getCardImage.CardImageFromPicsZip(carddatas.get(i).getId()+"jpg");
//            }catch (IOException e){
//                continue;
//            }
//            HashingAlgorithm hasher = new PerceptiveHash(32);
//            Hash hash0 = hasher.hash(img0);
//            Hash hash1 = hasher.hash(img1);
//            double similarityScore = hash0.normalizedHammingDistance(hash1);
//            if(similarityScore<0.6) {
//                return this.SearchCard(carddatas.get(i).getId()+"");
//            }
//        }
//        return "找不到資料";
//        return "";
//    }
}
