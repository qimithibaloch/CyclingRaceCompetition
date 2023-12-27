
package main.java.model;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CyclistList {
    public List<Cyclist> cyclists;

    public CyclistList() {
        this.cyclists = new ArrayList<>();
    }

    // Getters and Setters
    public void setCompetitorList(List<Cyclist> cyclists) {
        this.cyclists = cyclists;
    }

    public List<Cyclist> getCyclistList() {
        return this.cyclists;
    }

    /**
     */
    private static class HighestScoreResult {
        Cyclist cyclist;
        double score;

        HighestScoreResult(Cyclist cyclist, double score) {
            this.cyclist = cyclist;
            this.score = score;
        }
    }

    /**
    
     @param cyclist
      @return 
     */
    public void addCyclist(Cyclist cyclist) {
        this.cyclists.add(cyclist);
    }

    /**
    
      @param competitorNumber 
      @return 
     */
    public boolean removeCyclist(int cyclistNumber) {
        Iterator<Cyclist> iterator = cyclists.iterator();
        while (iterator.hasNext()) {
            Cyclist cyclist = iterator.next();
            if (cyclist.getCyclistsNumber() == cyclistNumber) {
                iterator.remove();
                return true; 
            }
        }
        return false;
    }

    /**
   
     @param cyclistNumber 
     @return
     */
    public Optional<Cyclist> findCyclistByNumber(int number) {
        return cyclists.stream()
                .filter(c -> c.getCyclistsNumber() == number)
                .findFirst();
    }

    /**
  
      @param fileName 
     @return 
     */
    public void loadCyclistsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                int number = Integer.parseInt(details[0].trim());
                String name = details[1].trim();
                String email = details[2].trim();
                int age = Integer.parseInt(details[3].trim());
                String gender = details[4].trim();
                String country = details[5].trim();
                String category = details[6].trim();
                String level = details[7].trim();
                int[] scores = Arrays.stream(details, 8, details.length).mapToInt(Integer::parseInt).toArray();

                Cyclist cyclist;
                switch (level.toLowerCase()) {
                    case "amateur":
                        cyclist = new AmateurCyclist(number, name, email, age, gender, country, category, level, scores);
                        break;
                    case "intermediate":
                        cyclist = new IntermediateCyclist(number, name, email, age, gender, country, category, level, scores);
                        break;
                    case "professional":
                        cyclist = new ProfessionalCyclist(number, name, email, age, gender, country, category, level, scores);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid cyclist level: " + level);
                }
                if (cyclist != null) {
                    this.addCyclist(cyclist);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
   
      @return 
     */
    public double findMeanOverallScore() {
        if (cyclists.isEmpty()) {
            return 0.0; 
        }
        double sum = 0.0;
        for (Cyclist cyclist : cyclists) {
            sum += cyclist.getOverallScore();
        }
        return sum / cyclists.size();
    }

    /**
  
     @return 
     */
    public double findMedianOverallScore() {
        List<Double> scores = cyclists.stream()
                .map(Cyclist::getOverallScore)
                .sorted()
                .collect(Collectors.toList());

        if (scores.isEmpty()) {
            return 0.0; 
        }

        int middle = scores.size() / 2;
        if (scores.size() % 2 == 1) {
            return scores.get(middle);
        } else {
            return (scores.get(middle - 1) + scores.get(middle)) / 2.0;
        }
    }

    /**
   
      @return 
     */
    public Set<Integer> findModeIndividualScores() {
        Map<Integer, Integer> scoreFrequencies = new HashMap<>();

        // Count the frequency of each score
        for (Cyclist cyclist : cyclists) {
            for (int score : cyclist.getScoreArray()) {
                scoreFrequencies.merge(score, 1, Integer::sum);
            }
        }

        if (scoreFrequencies.isEmpty()) {
            return Collections.emptySet(); 
        }

        int maxFrequency = Collections.max(scoreFrequencies.values());

        return scoreFrequencies.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    /**
   
     @return 
     */
    private HighestScoreResult findHighestScoreAndCyclist() {
        if (cyclists.isEmpty()) {
            return new HighestScoreResult(null, 0.0);
        }

        Cyclist highestScoringCyclist = null;
        double highestScore = Double.MIN_VALUE;

        for (Cyclist cyclist : cyclists) {
            double score = cyclist.getOverallScore();
            if (highestScoringCyclist == null || score > highestScore) {
                highestScoringCyclist = cyclist;
                highestScore = score;
            }
        }

        return new HighestScoreResult(highestScoringCyclist, highestScore);
    }

    /**

      @return The 
     */
    public Cyclist findDetailsOfHighestOverallScoreCyclist() {
        HighestScoreResult result = findHighestScoreAndCyclist();
        return result.cyclist;
    }

    /**
  
      @return 
     */
    public double findHighestOverallScore() {
        HighestScoreResult result = findHighestScoreAndCyclist();
        return result.score;
    }

    /**
 
      @return 
     */
    public Map<Integer, Integer> findFrequencyOfIndividualScores() {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Cyclist cyclist : cyclists) {
            for (int score : cyclist.getScoreArray()) {
                frequencyMap.put(score, frequencyMap.getOrDefault(score, 0) + 1);
            }
        }

        return frequencyMap;
    }

    /**
   
      @return 
     */
    public double findLowestOverallScore() {
        if (cyclists.isEmpty()) {
            return 0.0; 
        }

        double lowestScore = Double.MAX_VALUE; 

        for (Cyclist cyclist : cyclists) {
            double score = cyclist.getOverallScore();
            if (score < lowestScore) {
                lowestScore = score; 
            }
        }

        return lowestScore;
    }

    /**
  
      @param reportPath 
     */
    public void produceFinalReport(String reportPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
            writer.write("Table of Competitors:\n");
            for (Cyclist cyclist : cyclists) {
                writer.write(cyclist.getFullDetails() + "\n");
            }
            writer.newLine();

            Cyclist topCyclist = findDetailsOfHighestOverallScoreCyclist();
            writer.write("Cyclist with the Highest Overall Score:\n");
            if (topCyclist != null) {
                writer.write(topCyclist.getFullDetails() + "\n");
            } else {
                writer.write("No cyclists found.\n");
            }
            writer.newLine();

            Set<Integer> modeSet = findModeIndividualScores();
            writer.write("Mode of Individual Scores: ");
            if (!modeSet.isEmpty()) {
                for (Integer score : modeSet) {
                    writer.write(score + " ");
                }
                writer.newLine();
            } else {
                writer.write("No mode found.\n");
            }

            writer.write("Mean Overall Score: " + findMeanOverallScore() + "\n");
            writer.write("Median Overall Score: " + findMedianOverallScore() + "\n");
            writer.write("Lowest Overall Score: " + findLowestOverallScore() + "\n");

            writer.write("Frequency of Individual Scores:\n");
            Map<Integer, Integer> frequencyMap = findFrequencyOfIndividualScores();
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                writer.write("Score " + entry.getKey() + ": " + entry.getValue() + " times\n");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     */
    public void displayCyclistShortDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cyclist number: ");
        int number = scanner.nextInt();

        Optional<Cyclist> matchingCyclist = findCyclistByNumber(number);

        if (matchingCyclist.isPresent()) {
            System.out.println("Short details: " + matchingCyclist.get().getShortDetails());
        } else {
            System.out.println("No cyclist found with number: " + number);
        }
    }

    public void updateCompetitor(Cyclist updatedCyclist) {
        for (int i = 0; i < cyclists.size(); i++) {
            if (cyclists.get(i).getCyclistNumber() == updatedCyclist.getCyclistNumber()) {
                cyclists.set(i, updatedCyclist);
                break;
            }
        }
    }
}
