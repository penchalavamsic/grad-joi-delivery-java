package com.tw.joi.delivery.problems;

public class ManualSampleProblemTest {
    public static void main(String[] args) {
        testCalculateCost();
    }

    public static void testCalculateCost() {
        double distance = 3.0;
        double expectedCost = 50.0;
        double actualCost = SampleProblem.calculateCost(distance);

        if (Math.abs(actualCost - expectedCost) < 0.0001) {
            System.out.println("testCalculateCost PASSED: Cost for " + distance + " km is " + actualCost);
        } else {
            System.out.println("testCalculateCost FAILED: Expected " + expectedCost + " but got " + actualCost);
            System.exit(1);
        }
    }
}
