package com.Mattera.o7sidekick.entity.Market;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;

//Class that can check in a json named market
public abstract class MarketAnalyzer {

    public static void readMarketJsonFile(String fileName) throws IOException, IOException {
        Market myMarket = new Market();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(fileName);


        Market myObject = objectMapper.readValue(file, Market.class);
        //String marketDataAsString = ReflectionToStringBuilder.toString(myObject);
        myObject.seetheshitinit();

        //System.out.println(marketDataAsString);


    }


}
