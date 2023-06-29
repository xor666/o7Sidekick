package com.Mattera.o7sidekick.service;

import com.Mattera.o7sidekick.entity.Market.Market;
import com.Mattera.o7sidekick.repository.MarketRepositoryImpl;

public class MarketServiceImpl {

    private MarketRepositoryImpl marketRepository;

    public void createMarket(Market market){
        marketRepository.createMarket(market);

    }

    public Market getMarketById(int id){
        return marketRepository.getMarketByID(id);

    }



}
