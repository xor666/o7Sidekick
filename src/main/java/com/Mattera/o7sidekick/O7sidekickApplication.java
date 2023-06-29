package com.Mattera.o7sidekick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import 	com.Mattera.o7sidekick.EDlogsFilesScanner.JSONFinder;
import  com.Mattera.o7sidekick.others.display07;


@SpringBootApplication
public class O7sidekickApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(O7sidekickApplication.class, args);
		display07.display07();
		//MarketAnalyzer.readMarketJsonFile("C:\\Users\\pierre\\Saved Games\\Frontier Developments\\Elite Dangerous\\Market.json");
	    JSONFinder.checkEliteProcess();

	}

}
