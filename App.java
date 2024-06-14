import java.util.Scanner;

public class App {

     // Method finds the maximum grade in array and return it
     private static int findMaxGrade(int[] scores) {
        int maxGrade = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > maxGrade) {
                maxGrade = score;
            }
        }
        return maxGrade;
    }

    // Method to calculate minimum grade and return it 
    private static int findMinGrade(int[] scores) {
        int minGrade = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score < minGrade) {
                minGrade = score;
            }
        }
        return minGrade;
    }

    // Method Calculates the average grade.
    private static double calculateAverage(int[] scores) {
        double sumGrades = 0;
        for (int score : scores) {
            sumGrades += score;
        }
        return sumGrades / scores.length;
    }

    //Categorizes grades into ranges and counts the number of grades in each range.
    private static int[] categorizeGrades(int[] scores) {
        int[] stats = new int[5];
        for (int score : scores) {
            if (score <= 20) {
                stats[0]++;
            } else if (score <= 40) {
                stats[1]++;
            } else if (score <= 60) {
                stats[2]++;
            } else if (score <= 80) {
                stats[3]++;
            } else {
                stats[4]++;
            }
        }
        return stats;
    }

    //It displays the calculated maximum, minimum, and average grades.
    
    private static void displayResults(int maxGrade, int minGrade, double avgGrade) {
        System.out.println("\nValues:");
        System.out.println("The maximum grade is " + maxGrade);
        System.out.println("The minimum grade is " + minGrade);
        System.out.println("The average grade is " + avgGrade);
    }
       // Finds the maximum count in the stats array to determine the height of the graph.
       private static int findMaxCount(int[] stats) {
        int maxCount = 0;
        for (int count : stats) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    // Displays a bar graph of the grade distributions.
    private static void displayBarGraph(int[] stats) {
        System.out.println("\nGraph:");

        int maxCount = findMaxCount(stats);

        for (int i = maxCount; i > 0; i--) {
            System.out.print(String.format("%2d  >  ", i));
            for (int count : stats) {
                if (count >= i) {
                    System.out.print("#######   ");
                } else {
                    System.out.print("          ");
                }
            }
            System.out.println();
        }

        System.out.println("    +-----------+---------+---------+---------+---------+");
        System.out.println("    I   0-20    I  21-40  I  41-60  I  61-80  I  81-100 I");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting users input
        System.out.println("Enter the grades vary from 0 to 100 separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int[] scores = new int[input.length];

        // Convert input strings to integers
        for (int i = 0; i < input.length; i++) {
            scores[i] = Integer.parseInt(input[i]);
        }

        // Calculate max, min, and average grades
        int maxGrade = findMaxGrade(scores);
        int minGrade = findMinGrade(scores);
        double avgGrade = calculateAverage(scores);

        // ranges of grades
        int[] stats = categorizeGrades(scores);

        // Display results
        displayResults(maxGrade, minGrade, avgGrade);

        // Display the bar graph
        displayBarGraph(stats);

        scanner.close();
    }
}
