package com.day2.Hands_OnPracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IPLAndCensor {
    public static class IPLMatch {
        private String matchId;
        private String team1;
        private String team2;
        private String playerOfTheMatch;

        // Getters and Setters
        public String getMatchId() {
            return matchId;
        }

        public void setMatchId(String matchId) {
            this.matchId = matchId;
        }

        public String getTeam1() {
            return team1;
        }

        public void setTeam1(String team1) {
            this.team1 = team1;
        }

        public String getTeam2() {
            return team2;
        }

        public void setTeam2(String team2) {
            this.team2 = team2;
        }

        public String getPlayerOfTheMatch() {
            return playerOfTheMatch;
        }

        public void setPlayerOfTheMatch(String playerOfTheMatch) {
            this.playerOfTheMatch = playerOfTheMatch;
        }
    }

    // Apply censorship: Mask the team names and redact the Player of the Match
    public static IPLMatch applyCensorship(IPLMatch match) {
        // Mask team names
        match.setTeam1(maskTeamName(match.getTeam1()));
        match.setTeam2(maskTeamName(match.getTeam2()));

        // Redact Player of the Match
        match.setPlayerOfTheMatch("REDACTED");

        return match;
    }

    // Mask the team name by replacing part of the name with ***
    private static String maskTeamName(String teamName) {
        if (teamName != null && teamName.contains(" ")) {
            String[] parts = teamName.split(" ");
            return parts[0] + " ***";
        }
        return teamName;
    }

    // Read JSON file and process the data
    public static List<IPLMatch> readJsonData(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        IPLMatch[] matches = objectMapper.readValue(new File(jsonFilePath), IPLMatch[].class);
        List<IPLMatch> matchList = new ArrayList<>();
        for (IPLMatch match : matches) {
            matchList.add(match);
        }
        return matchList;
    }

    // Write censored data to JSON file
    public static void writeJsonData(String jsonFilePath, List<IPLMatch> matchList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(jsonFilePath), matchList);
    }

    // Read CSV file and process the data
    public static List<IPLMatch> readCsvData(String csvFilePath) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));
        List<IPLMatch> matchList = new ArrayList<>();
        String[] line;

        // Skip header
        reader.readNext();

        // Read each line and map to IPLMatch
        while ((line = reader.readNext()) != null) {
            IPLMatch match = new IPLMatch();
            match.setMatchId(line[0]);
            match.setTeam1(line[1]);
            match.setTeam2(line[2]);
            match.setPlayerOfTheMatch(line[3]);
            matchList.add(match);
        }

        reader.close();
        return matchList;
    }

    // Write censored data to CSV file
    public static void writeCsvData(String csvFilePath, List<IPLMatch> matchList) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));

        // Write header
        writer.writeNext(new String[] { "MatchId", "Team1", "Team2", "PlayerOfTheMatch" });

        // Write each match
        for (IPLMatch match : matchList) {
            writer.writeNext(new String[] {
                    match.getMatchId(),
                    match.getTeam1(),
                    match.getTeam2(),
                    match.getPlayerOfTheMatch()
            });
        }

        writer.close();
    }

    public static void main(String[] args) {
        try {
            // Reading JSON data
            List<IPLMatch> matchesFromJson = readJsonData("D:\\Capgemini\\WEEK-05-New\\src\\main\\resources\\ipl_matches.json");
            List<IPLMatch> censoredJsonMatches = new ArrayList<>();
            for (IPLMatch match : matchesFromJson) {
                censoredJsonMatches.add(applyCensorship(match));
            }
            // Writing censored JSON data to a new file
            writeJsonData("D:\\Capgemini\\WEEK-05-New\\src\\main\\resources\\censored_ipl_matches.json", censoredJsonMatches);

            List<IPLMatch> matchesFromCsv = readCsvData("D:\\Capgemini\\WEEK-05-New\\src\\main\\resources\\ipl_matches.csv");
            List<IPLMatch> censoredCsvMatches = new ArrayList<>();
            for (IPLMatch match : matchesFromCsv) {
                censoredCsvMatches.add(applyCensorship(match));
            }
            writeCsvData("D:\\Capgemini\\WEEK-05-New\\src\\main\\resources\\censored_ipl_matches.csv", censoredCsvMatches);

            System.out.println("Data censored and written to new files successfully!");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
