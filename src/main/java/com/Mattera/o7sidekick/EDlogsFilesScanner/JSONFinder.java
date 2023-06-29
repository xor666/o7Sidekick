package com.Mattera.o7sidekick.EDlogsFilesScanner;

import com.Mattera.o7sidekick.entity.Market.MarketAnalyzer;
import com.Mattera.o7sidekick.entity.OtherTimeStamp.OtherTimeStamp;
import com.Mattera.o7sidekick.others.consoleColor;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Optional;

public abstract class JSONFinder {

    static Boolean STOP =false;

//code honteusement copié collé je l'admets




    public static void checkEliteProcess() throws InterruptedException, IOException {
        String processName = "EliteDangerous64.exe";
        //String processName = "EliteDangerous64.exe";
        boolean wasRunning = false;
        while (true) {
            Optional<ProcessHandle> handle = ProcessHandle.allProcesses()
                    .filter(p -> p.info().command().orElse("").contains(processName))
                    .findFirst();
            boolean isRunning = handle.isPresent() && handle.get().isAlive();
            if (isRunning && !wasRunning) {
                System.out.println(processName + " a été redémarré.");
               checkJSON(); //check data in JSON Journal file


            } else if (!isRunning && wasRunning) {
                System.out.println(processName + " a été arrêté.");
                STOP =true;
            }
            wasRunning = isRunning;
            Thread.sleep(10000); // Pause de 10 secondes avant la prochaine vérification
        }

    }


    //check data in JSON Elite journal file
    public static void checkJSON() throws IOException, InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        String month = ""; //exist because
        // month value is equal to 4 instead of 04 for example

        if (now.getMonthValue() < 9) {
            month = "0" + now.getMonthValue();
        }

        String JFileName = "Journal." + now.getYear() + "-" + month + "-" + now.getDayOfMonth() + "T";
        //consoleColor.showMessageColorized(String.valueOf(JFileName),"red"); //permets d'avoir la liste des fichiers similaires
        consoleColor.showMessageColorized("Le bon fichier devrait commencer par: " + JFileName, "orange");

        //default location or the only one idk
        String path = "%userprofile%\\Saved Games\\Frontier Developments\\Elite Dangerous\\";



        File folder = new File("C:\\Users\\pierre\\Saved Games\\Frontier Developments\\Elite Dangerous"); // Remplacez "/chemin/vers/le/dossier" par le chemin absolu de votre dossier
        File[] files = folder.listFiles(new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.startsWith(JFileName);
            }
        });

        File lastJFile = files[files.length - 1];
        System.out.println("Le dernier fichier de logs trouvé est le: " + lastJFile);

        String fileName = lastJFile.toString(); // Le nom du fichier JSON
        consoleColor.showMessageColorized(lastJFile.toString(),"green");


        Path logFile = Paths.get(lastJFile.toString());
        WatchService watcher = FileSystems.getDefault().newWatchService();
        logFile.getParent().register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Watching log file for changes...");
        String lastLine ="";

        while (true) {
            if(lastLine.contains("\"event\":\"Shutdown\"")==false) {
                WatchKey key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY && event.context().equals(logFile.getFileName())) {
                        //System.out.println("Log file modified: " + logFile);
                        lastLine = readLastLine(logFile.toString());
                        System.out.println("Dernière ligne: " + lastLine);

                        OtherTimeStamp.sendOtherDataType(lastLine);
                        System.out.println("Journal envoyé via API à l'adresse http://localhost:8080/dashboard");
                        System.out.println(lastLine);
                    }

                }
                key.reset();

            } if (lastLine.contains("\"event\":\"Market\"")==true) {

                MarketAnalyzer.readMarketJsonFile("C:\\Users\\pierre\\Saved Games\\Frontier Developments\\Elite Dangerous\\Market.json");
                System.out.println("Ajout et ou mise à jour du marché");


            }
            /*if(lastLine.contains("\"event\":\"FSSAllBodiesFound\"")==true){
                    consoleColor.showMessageColorized("Système Mappé à 100% bravo  :-)", "green");
                    //To do: Create an History for my E-penis
                    //BUT this event seems to not be triggered at everytime i got 100% it's strange or a bug

            }*/
            if(lastLine.contains("\"event\":\"Shutdown\"")){
                System.out.println("Logiciel éteint");
                break;
            }
            if(lastLine.contains("\"event\":\"StartJump\"")){
                consoleColor.showMessageColorized("FAUT AJOUTER LE SYSTEME DANS LA BDD");
                //to do : ajouter le système dans la bdd
            }
            else{

            }

        }
        checkEliteProcess();
    }


    public static String readLastLine(String logFile) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(logFile, "r")) {
            long length = file.length();
            if (length == 0) {
                return "";
            } else {
                long position = length - 2;
                StringBuilder sb = new StringBuilder();
                file.seek(position);
                int character = file.read();
                while (character != -1 && character != '\n') {
                    sb.append((char) character);
                    position--;
                    file.seek(position);
                    character = file.read();
                }
                return sb.reverse().toString();
            }
        }
    }
}


