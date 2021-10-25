package com.example.demo.ImageSearch;



import com.example.demo.LineWebHook;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class GetCardImage {
    public File CardImageFromLine(String MessageID) throws IOException {
        String lineurl = "https://api-data.line.me/v2/bot/message/"+MessageID+"/content";
        Client httpclient = ClientBuilder.newClient();
        WebTarget target = httpclient.target(lineurl);
        Response response = target.request().header(HttpHeaders.AUTHORIZATION, LineWebHook.AccessToken).get();
        InputStream inputStream = response.readEntity(InputStream.class);
        File tempFile = File.createTempFile("CardFromLine","jpg");
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        IOUtils.copy(inputStream,outputStream);
        File cardimage = new File("CardFromLine.jpg");
        tempFile.delete();
        return cardimage;
    }
    public File CardImageFromPicsZip(String FileName) throws IOException {
        ZipFile zipFile = new ZipFile("pics.zip");
        FileHeader fileHeader = zipFile.getFileHeader(FileName);
        InputStream inputStream = zipFile.getInputStream(fileHeader);

        File tempFile = File.createTempFile("CardFromLocal","jpg");
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        IOUtils.copy(inputStream,outputStream);
        File cardimage = new File("CardFromLocal.jpg");
        tempFile.delete();
        return cardimage;
    }
}
