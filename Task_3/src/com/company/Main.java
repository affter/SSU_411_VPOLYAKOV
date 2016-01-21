package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Busket busket = new Busket();
        int action = -1;
        Scanner in = new Scanner(System.in);
        while (action < 0) {
            System.out.println("Выберите действие:");
            System.out.println("1) Добавить продукт в корзину.");
            System.out.println("2) Удалить продукт из корзины.");
            System.out.println("3) Вывести содержимое корзины.");
            System.out.println("4) Обновить стоимость продукта.");
            System.out.println("5) Очистить корзину.");
            System.out.println("0) Выход.");
            try {
                String temp = in.nextLine();
                action = Integer.parseInt(temp);
            } catch (Exception e) {
                System.out.println("Некорректный ввод!");
                continue;
            }
            if (action==0) break;
            switch (action) {
                case 1: {
                    System.out.print("Введите наименование продукта:");
                        String temp = in.nextLine();
                    System.out.print("Введите стоимость продукта:");
                    try {
                        String tempInt = in.nextLine();
                        int quantity = Integer.parseInt(tempInt);
                        busket.addProduct(temp,quantity);
                    } catch (Exception e) {
                        System.out.println("Некорректный ввод!");
                    }
                    action = -1;
                    break;
                }
                case 2:{
                    System.out.print("Введите наименование продукта:");
                    String temp = in.nextLine();
                    try {
                        busket.removeProduct(temp);
                    } catch (Exception e) {
                        System.out.println("Некорректный ввод!");
                    }
                    action = -1;
                    break;
                }
                case 3:{
                    List<String> products = busket.getProducts();
                    for (int i = 0;i<products.size();i++)
                        System.out.print(products.get(i) + "\t" + busket.getProductQuantity(products.get(i)) + "\n");
                    action = -1;
                    break;
                }
                case 4:{
                    System.out.print("Введите наименование продукта:");
                    String temp = in.nextLine();
                    if (busket.getProducts().contains(temp)) {
                        System.out.print("Введите новую стоимость продукта:");
                        try {
                            String tempInt = in.nextLine();
                            int quantity = Integer.parseInt(tempInt);
                            busket.updateProductQuantity(temp, quantity);
                        } catch (Exception e) {
                            System.out.println("Некорректный ввод!");
                        }
                    }
                    else {
                        System.out.println("Некорректный ввод!");
                    }
                    action = -1;
                    break;
                }
                case 5:{
                    busket.clear();
                    action = -1;
                    break;
                }
                default: {
                    action = -1;
                    System.out.println("Некорректный ввод!");
                    break;
                }
            }
        }
    }
}
