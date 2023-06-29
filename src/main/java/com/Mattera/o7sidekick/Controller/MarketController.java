package com.Mattera.o7sidekick.Controller;

import com.Mattera.o7sidekick.entity.Market.Market;
import com.Mattera.o7sidekick.service.MarketServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/o7API/public/Market")
public class MarketController {

    private MarketServiceImpl marketService;

    //////////// si je me rappelle bien on est ici sur la partie future api DONC normal que ca ait une drole de gueule mais trust the process
    public MarketController (){this.marketService= new MarketServiceImpl();}

    @PutMapping("/object/{id}")
    public ResponseEntity createMarket(@RequestBody String json, @PathVariable("id") int id){
        try {
            //Transformer l'object en paramètre en json pour en faire un objet qui existe (transient)
            ObjectMapper objectMapper = new ObjectMapper();
            Market marketToInsert = objectMapper.readValue(json, Market.class);

            //utiliser l'objet que j'ai créer précédemment
            marketService.createMarket(marketToInsert);
            return ResponseEntity.status(HttpStatus.OK).body("Objet mis à jour avec succès.");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Marché non ajouté :(");
        }
    };



}
