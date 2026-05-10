import Models.ItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();
        values.add(10);
        weights.add(8);

        values.add(5);
        weights.add(3);

        values.add(12);
        weights.add(10);

        values.add(6);
        weights.add(5);

        values.add(2);
        weights.add(2);

        //for 2 lists in bruteforce
/*
        values.add(5); weights.add(3);
        values.add(5); weights.add(3);
        values.add(3); weights.add(2);
*/

        Knapsack k = new Knapsack(10,weights,values);



        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to test?(to exit \\x)\n1. Brute Force\n2. Greedy Density Approach\n3. Both");
        while (input.hasNextLine()) {
            String choiceStr = input.nextLine();
            if(choiceStr.equals("\\x")){
                System.exit(0);
            }
            int choice = Integer.parseInt(choiceStr);
            System.out.println("\n");
            switch (choice) {
                case 1:
                    long start1 = System.nanoTime();
                    List<List<ItemModel>> bf = k.bruteForce();
                    long end1 = System.nanoTime();
                    System.out.println("Result of brute force: " + bf);
                    System.out.println("w = " + bf.get(0).stream().mapToInt(ItemModel::weight).sum() + "; v = " + bf.get(0).stream().mapToInt(ItemModel::value).sum());
                    System.out.println("Time: " + (end1 - start1) / 1_000_000.0 + " ms");
                    break;

                case 2:
                    long start2 = System.nanoTime();
                    List<ItemModel> gr = k.greedyDensityApproach();
                    long end2 = System.nanoTime();
                    System.out.println("Result of Greedy Density Approach: " + gr);
                    System.out.println("w = " + gr.stream().mapToInt(ItemModel::weight).sum() + "; v = " + gr.stream().mapToInt(ItemModel::value).sum());
                    System.out.println("Time: " + (end2 - start2) / 1_000_000.0 + " ms");
                    break;

                case 3:
                    long start3 = System.nanoTime();
                    List<List<ItemModel>> bf3 = k.bruteForce();
                    long end3 = System.nanoTime();

                    long start4 = System.nanoTime();
                    List<ItemModel> gr3 = k.greedyDensityApproach();
                    long end4 = System.nanoTime();

                    System.out.println("Result of brute force: " + bf3);
                    System.out.println("w = " + bf3.get(0).stream().mapToInt(ItemModel::weight).sum() + "; v = " + bf3.get(0).stream().mapToInt(ItemModel::value).sum());
                    System.out.println("Time: " + (end3 - start3) / 1_000_000.0 + " ms\n");
                    System.out.println("Result of Greedy Density Approach: " + gr3);
                    System.out.println("w = " + gr3.stream().mapToInt(ItemModel::weight).sum() + "; v = " + gr3.stream().mapToInt(ItemModel::value).sum());
                    System.out.println("Time: " + (end4 - start4) / 1_000_000.0 + " ms\n");


                    int bfValue = bf3.get(0).stream().mapToInt(ItemModel::value).sum();
                    int grValue = gr3.stream().mapToInt(ItemModel::value).sum();
                    System.out.println("Brute force best value: " + bfValue);
                    System.out.println("Greedy best value: " + grValue);
                    System.out.println("Same result: " + (bfValue == grValue));
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("\n\n\nWhat would you like to test?(to exit \\x)\n1. Brute Force\n2. Greedy Density Approach\n3. Both");
        }
    }
}
