package com.binary_studio.academy_coin;

import java.util.stream.Stream;

public final class AcademyCoin {

    private AcademyCoin() {
    }

    public static int maxProfitWithoutKnowingTheFuture(Stream<Integer> prices, int riskValue) {
        Integer[] pricesArray = prices.toArray(Integer[]::new);
        long numbOfDays = pricesArray.length;
        int income = 0;
        int onArms = 0;

        for (int i = 0; i < numbOfDays - 1; i++) {

            if (onArms == 0 && pricesArray[i] < riskValue) {
                onArms = pricesArray[i];
                income -= pricesArray[i];
            }

            if (onArms != 0 && onArms < pricesArray[i]) {
                income += pricesArray[i];
                onArms = 0;
            }
        }

        return income;
    }

    public static int maxProfit(Stream<Integer> prices) {
        Integer[] pricesArray = prices.toArray(Integer[]::new);
        long numbOfDays = pricesArray.length;
        int income = 0;

        for (int i = 0; i < numbOfDays-1; i++) {

            if (pricesArray[i] < pricesArray[i+1]) {
                int current = pricesArray[i+1];
                int nextIndex = i+2;

                while (nextIndex < numbOfDays && current <= pricesArray[nextIndex]) {
                    current = pricesArray[nextIndex];
                    nextIndex++;
                }

                income += current - pricesArray[i];
                i = nextIndex-1;
            }
        }

        return income;
    }

}
