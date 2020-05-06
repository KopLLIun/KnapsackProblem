package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input max weight of knapsack:");
        int maxWeight = input.nextInt();
        Item[] items = KnapsackProblem.initData();
        KnapsackProblem.takeMostValuable(items, maxWeight);
    }
}
