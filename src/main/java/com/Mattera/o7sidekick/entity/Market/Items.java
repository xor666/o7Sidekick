package com.Mattera.o7sidekick.entity.Market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Items(){

    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Items(String id, String name_localised, String category, String category_Localised, int buyPrice, int meanPrice, int sellPrice, int stockBracket, int demandBracket, int stock, int demand, boolean consumer, boolean producer) {
        this.id = id;
        Name_localised = name_localised;
        Category = category;
        Category_Localised = category_Localised;
        BuyPrice = buyPrice;
        MeanPrice = meanPrice;
        SellPrice = sellPrice;
        StockBracket = stockBracket;
        DemandBracket = demandBracket;
        Stock = stock;
        Demand = demand;
        Consumer = consumer;
        Producer = producer;
    }





    public String getId() {
        return id.toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_localised() {
        return Name_localised;
    }

    public void setName_localised(String name_localised) {
        Name_localised = name_localised;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCategory_Localised() {
        return Category_Localised;
    }

    public void setCategory_Localised(String category_Localised) {
        Category_Localised = category_Localised;
    }

    public int getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        BuyPrice = buyPrice;
    }

    public int getMeanPrice() {
        return MeanPrice;
    }

    public void setMeanPrice(int meanPrice) {
        MeanPrice = meanPrice;
    }

    public int getSellPrice() {
        return SellPrice;
    }

    public void setSellPrice(int sellPrice) {
        SellPrice = sellPrice;
    }

    public int getStockBracket() {
        return StockBracket;
    }

    public void setStockBracket(int stockBracket) {
        StockBracket = stockBracket;
    }

    public int getDemandBracket() {
        return DemandBracket;
    }

    public void setDemandBracket(int demandBracket) {
        DemandBracket = demandBracket;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getDemand() {
        return Demand;
    }

    public void setDemand(int demand) {
        Demand = demand;
    }

    public boolean isConsumer() {
        return Consumer;
    }

    public void setConsumer(boolean consumer) {
        Consumer = consumer;
    }

    public boolean isProducer() {
        return Producer;
    }

    public void setProducer(boolean producer) {
        Producer = producer;
    }
    @JsonProperty("id")
    private String id = "";
    @JsonProperty("Name_Localised")
    private String Name_localised = "";
    @JsonProperty("Category")
    private String Category = "";
    @JsonProperty("Category_Localised")
    private String Category_Localised =""; // i think we do not need to use it for the moment
    @JsonProperty("BuyPrice")
    private int BuyPrice=0;
    @JsonProperty("MeanPrice")
    private int MeanPrice=0;
    @JsonProperty("SellPrice")
    private int SellPrice=0;
    @JsonProperty("StockBracket")
    private int StockBracket=0; //maybe don't give a shit
    @JsonProperty("DemandBracket")
    private int DemandBracket=0;
    @JsonProperty("Stock")
    private int Stock =0;
    @JsonProperty("Demand")
    private int Demand=0;
    @JsonProperty("Consumer")
    private boolean Consumer = false; //import
    @JsonProperty("Producer")
    private boolean Producer = true; //export





}


/*
example of an item row into a market json object ( Market.java )
{ "id":128672314,
     "Name":"$evacuationshelter_name;",
     "Name_Localised":"Abri d'urgence",
     "Category":"$MARKET_category_consumer_items;",
     "Category_Localised":"Biens de consommation",
     "BuyPrice":302,
      "SellPrice":271,
      "MeanPrice":522,
     "StockBracket":2,
      "DemandBracket":0,
       "Stock":10079,
       "Demand":1,
        "Consumer":false,
        "Producer":true, "Rare":false },




* */