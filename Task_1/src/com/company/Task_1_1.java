package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Task_1_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = 0;
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MMMM");
        while (year < 1800 || year > 2020) {
            System.out.print("Введите год: ");
            try {year = Integer.parseInt(in.nextLine());}
            catch (Exception e){}
            if (year < 1800 || year > 2020)
                System.out.println("Год введен неверно!");
        }
        calendar.set(calendar.DAY_OF_MONTH,13);
        calendar.set(calendar.YEAR,year);
        for (int i = 0; i<12; i++){
            calendar.set(calendar.MONTH,i);
            if (calendar.get(calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
                System.out.println(dateFormat.format(calendar.getTime()));
        }
    }
}