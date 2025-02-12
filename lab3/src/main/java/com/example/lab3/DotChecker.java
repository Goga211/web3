package com.example.lab3;

public class DotChecker {

    public static boolean checkDot(float x, float y, float r) {
        return checkFirstQuarter(x, y, r) || checkSecondQuarter(x, y, r) || checkThirdQuarter(x, y, r) || checkFourthQuarter(x, y, r);
    }

    private static boolean checkFirstQuarter(float x, float y, float r) {
        if (x >= 0 && y >= 0) {
            return (y <= (-x + r));
        }
        return false;
    }

    private static boolean checkSecondQuarter(float x, float y, float r) {
        if(x <= 0 && y >= 0){
            return (x >= -r && y <= r/2);
        }
        return false;
    }

    private static boolean checkThirdQuarter(float x, float y, float r) {
        if (x <= 0 && y <= 0) {
            return (x * x + y * y <= r * r);
        }
        return false;
    }

    private static boolean checkFourthQuarter(float x, float y, float r) {
        return false;
    }

}
