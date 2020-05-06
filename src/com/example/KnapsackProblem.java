package com.example;

import java.util.HashMap;
import java.util.Scanner;

public class KnapsackProblem {

/*          link - https://economics.hse.ru/data/2019/11/14/1534732278/Лекция10.pdf
            Пусть 𝐴(𝑘, 𝑠) – максимальная стоимость предметов.
            Найдем 𝐴(𝑘, 𝑠), k  {1, .., k} - кол-во предметов, w - вес, p - стоимость, s - максимальная вместительность.
            Тогда:
                • 𝐴(𝑘, 0) = 0;
                • 𝐴(0, 𝑠) = 0.
            Возможны 2 варианта:
                • Предмет k не попал в рюкзак - 𝐴(𝑘, 𝑠)= 𝐴(𝑘 − 1, 𝑠);
                • Предмет k попал в рюкзак - 𝐴(𝑘, 𝑠) = 𝐴(𝑘 − 1, 𝑠 − 𝑤_𝑘 + 𝑝_𝑘);
            Следовательно, 𝐴(𝑘, 𝑠) = max(𝐴(𝑘 − 1, 𝑠) , 𝐴(𝑘 − 1, 𝑠 − 𝑤_𝑘) + 𝑝_𝑘)
            Стоимость искомого набора равна 𝐴(𝑁, 𝑊)*/

    public static void takeMostValuable(Item[] items, int maxWeight) {
        int[][] maxValue = new int[items.length + 1][maxWeight + 1];
/*        for (int j = 0; j < maxWeight; j++) {
            maxValue[0][j] = 0;
        }*/

        for (int i = 1; i < items.length + 1; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                if (items[i - 1].getWeight() > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    maxValue[i][j] = getMax(maxValue[i - 1][j], maxValue[i - 1][j - items[i - 1].getWeight()] +
                            items[i - 1].getValue());
                }
            }
        }

        for (int i = 0; i < items.length + 1; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                System.out.print(maxValue[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getMax(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber > 0 ? firstNumber : secondNumber;
    }

    public static Item[] initData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input number of items:");
        int numberOfItems = input.nextInt();
        Item[] items = new Item[numberOfItems];
        for (int index = 0; index < items.length; index++) {
            System.out.println("Input weight of item " + index + ":");
            int weight = input.nextInt();
            System.out.println("input value of item " + index + ":");
            int value = input.nextInt();
            items[index] = new Item(index, weight, value);
        }
        return items;
    }
}
