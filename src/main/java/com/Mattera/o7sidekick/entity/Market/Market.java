package com.Mattera.o7sidekick.entity.Market;


import java.util.List;

import com.Mattera.o7sidekick.others.consoleColor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Market {
    public Market() {

    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMarketID() {
        return marketID;
    }

    public void setMarketID(String marketID) {
        this.marketID = marketID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public int getStarSystem() {
        return StarSystem;
    }

    public void setStarSystem(int starSystem) {
        StarSystem = starSystem;
    }

    public List<com.Mattera.o7sidekick.entity.Market.Items> getItems() {
        return Items;
    }

    public void setItems(List<com.Mattera.o7sidekick.entity.Market.Items> items) {
        Items = items;
    }

//yyyy-MM-dd'T'HH:mm:ss'Z'

    private String timestamp;
    @JsonIgnore
    @JsonProperty("event")
    private String event;
    @JsonProperty("marketID")
    @Id
    private String marketID = "";
    @JsonProperty("stationName")
    private String stationName = "";
    @JsonProperty("StationType")
    private String stationType = "";
    @JsonProperty("StarSystem")
    private int StarSystem = 0;
    @JsonProperty("Items")
    private List<Items> Items;

    void seetheshitinit() {
        consoleColor.showMessageColorized("\n");
        consoleColor.showMessageColorized("Disponible à l'achat dans ce marché \n ");
        for (Items thisITem: Items) {
                        if(thisITem.getStock() >0) {
                            System.out.println("Marchandise: "+thisITem.getName_localised().toString()+ ", est disponible au prix de : "+thisITem.getBuyPrice()+"CR");
                        }
        }
    }







}




