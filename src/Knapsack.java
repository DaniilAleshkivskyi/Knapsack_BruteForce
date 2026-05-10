import Models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private final List<Integer> itemWeights;
    private final List<Integer> itemValues;
    private final int capacity;
    public Knapsack(int capacity, List<Integer> itemWeights, List<Integer> itemValues) {
        this.capacity = capacity;
        this.itemWeights = itemWeights;
        this.itemValues = itemValues;
    }

    public List<List<ItemModel>> bruteForce() {
        int bestValue = 0;
        List<List<ItemModel>> bestSets = new ArrayList<>();
        //(1 << 0) -> 1 * (2^0)
        //(1 << 1) -> 1 * (2^1)
        //(1 << 2) -> 1 * (2^2)...
        // << - powers 2 by n
        //as we neec to calc how many possible ways there are and we can only take and not take its 2^n and (1 << n) implies 1 * 2^n
        for (int i = 0; i < (1 << itemValues.size()); i++) {
            int totalWeight = 0;
            int totalValue = 0;

            List<ItemModel> currentSet = new ArrayList<>();
            String encodedValue = Functions.encodeBin(i, itemValues.size());
            String[] arrValues = encodedValue.split("");

            for (int j = arrValues.length-1; j >= 0; j--) {
                if (arrValues[j].equals("1")) {
                    totalWeight += itemWeights.get(j);
                    totalValue += itemValues.get(j);
                    currentSet.add(new ItemModel(itemWeights.get(j), itemValues.get(j)));
                }
            }

            if (totalWeight <= capacity) {
                if (totalValue > bestValue) {
                    bestValue = totalValue;
                    bestSets.clear();
                    bestSets.add(currentSet);
                } else if (totalValue == bestValue) {
                    bestSets.add(currentSet);
                }
            }
        }

        return bestSets;
    }

    public List<ItemModel> greedyDensityApproach() {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < itemValues.size(); i++) {
            indices.add(i);
        }

        indices.sort((a, b) -> {
            // greedy approach is to divide value by weight so if our value is 4 and weight is 2 it's cost is 4/2 -> 2, this makes it effective jn cae of calculations
            double costA = (double) itemValues.get(a) / itemWeights.get(a);
            double costB = (double) itemValues.get(b) / itemWeights.get(b);
            return Double.compare(costB, costA);// comparing b and a because we want first to be biggest -> [3,2,1] not [1,2,3]
        });

        List<ItemModel> result = new ArrayList<>();
        int totalWeight = 0;

        for (int idx : indices) {
            int w = itemWeights.get(idx);

            if (totalWeight + w <= capacity) {
                totalWeight += w;
                result.add(new ItemModel(w, itemValues.get(idx)));
            }
        }

        return result;
    }
}
