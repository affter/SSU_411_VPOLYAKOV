package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Task_1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = 0,month=-1;
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("MMMM");
        while (year < 1800 || year > 2020) {
            System.out.print("Введите год: ");
            try {year = Integer.parseInt(in.nextLine());}
            catch (Exception e){}
            if (year < 1800 || year > 2020)
                System.out.println("Год введен неверно!");
        }
        while (month < 1 || month > 12) {
            System.out.print("Введите месяц: ");
            try {month = Integer.parseInt(in.nextLine());}
            catch (Exception e){}
            if (month < 1 || month > 12)
                System.out.println("Месяц введен неверно!");
        }
        calendar.set(calendar.DAY_OF_MONTH,13);
        calendar.set(calendar.YEAR,year);
        calendar.set(calendar.MONTH,month-1);
        int count = 0;
        while (calendar.compareTo(Calendar.getInstance())<0){
            if(calendar.get(calendar.DAY_OF_WEEK) == calendar.FRIDAY) {
                System.out.println(calendar.get(calendar.YEAR));
                count++;
            }
            year++;
        calendar.set(calendar.YEAR,year);
        }
        System.out.println("Всего совпадений:" + count);
        }
    }
