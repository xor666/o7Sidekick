package com.Mattera.o7sidekick.entity.OtherTimeStamp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Type;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

//OBject le plus simple du programme on se fiche de le mettre dans une base de donnée on veut juste un flux constant sur une requête http

public abstract class OtherTimeStamp {

    private String timeStampGiven= "";


    public OtherTimeStamp(String oneString){
        this.timeStampGiven = oneString;

    }

    public String getTimeStampGiven() {
        return timeStampGiven;
    }

    public void setTimeStampGiven(String timeStampGiven) {
        this.timeStampGiven = timeStampGiven;
    }

    public static void sendOtherDataType(String JSON){
        try {
            String url = "http://localhost:8080/dashboard";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            OutputStream outputStream = con.getOutputStream();
            outputStream.write(JSON.getBytes());
            outputStream.flush();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);

        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }










}
