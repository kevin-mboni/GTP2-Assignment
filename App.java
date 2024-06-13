import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the grades vary from 0 to 100 separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int n = input.length;
        int[] scores = new int[n];
        
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(input[i]);
        }

        int maxGrade = Integer.MIN_VALUE;
        int minGrade = Integer.MAX_VALUE;
        double sumGrades = 0;

        for (int score : scores) {
            if (score > maxGrade) {
                maxGrade = score;
            }
            if (score < minGrade) {
                minGrade = score;
            }
            sumGrades += score;
        }

        double avgGrade = sumGrades / n;

        // Create the stats array
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

        // Display the values
        System.out.println("\nValues:");
        System.out.println("The maximum grade is " + maxGrade);
        System.out.println("The minimum grade is " + minGrade);
        System.out.println("The average grade is " + avgGrade);

        // Display the bar graph
        System.out.println("\nGraph:");
        
        int maxCount = 0;
        for (int count : stats) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
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
}
