package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Integer, Company> companies = new HashMap<>();
        File information = new File("Data\\Information.csv");
        File result = new File("Data\\Result.csv");
        BufferedReader reader = new BufferedReader(new FileReader(information));
        BufferedWriter writer = new BufferedWriter(new FileWriter(result));
        String temp;
        BigDecimal transactionSize;
        int lineCount;
        String[] splits;
        reader.readLine();
        Company sender;
        Company receiver;
        Company company;
        File transactionFolder = new File("Data");
        while ((temp = reader.readLine()) != null) {
            try {
                splits = temp.split(";");
                if (!companies.containsKey(Integer.parseInt(splits[1]))) {
                    companies.put(Integer.parseInt(splits[1]), new Company(splits[0],
                            Integer.parseInt(splits[1]), new BigDecimal(splits[2])));
                    System.out.println("Компания " + splits[0] + " с номером счёта " + splits[1] + " успешно добавлена");
                } else {
                    System.out.println("Компания с номером счёта " + splits[1] + " уже существует");
                }
            } catch (Exception e) {
                System.out.println("Некорректная запись в информационном файле: " + temp);
            }
        }
        for (File transaction : transactionFolder.listFiles()) {
            if (transaction.getPath().matches("^Data\\\\Transaction[0-9]+\\.csv$")) {
                try {
                    lineCount=1;
                    reader = new BufferedReader(new FileReader(transaction));
                    reader.readLine();
                    while ((temp = reader.readLine()) != null) {
                        splits = temp.split(";");
                        if ((companies.containsKey(Integer.parseInt(splits[0]))) &&
                                (companies.get(Integer.parseInt(splits[0])).getName().equals(splits[1]))){
                            if ((companies.containsKey(Integer.parseInt(splits[0]))) &&
                                    (companies.get(Integer.parseInt(splits[2])).getName().equals(splits[3]))){
                                if (companies.get(Integer.parseInt(splits[2])).getBalance().compareTo(new BigDecimal(splits[4]))>=0){
                                    transactionSize = new BigDecimal(splits[4]);
                                    sender = companies.get(Integer.parseInt(splits[0]));
                                    receiver = companies.get(Integer.parseInt(splits[2]));
                                    sender.setBalance(sender.getBalance().subtract(transactionSize));
                                    receiver.setBalance(receiver.getBalance().add(transactionSize));
                                } else{
                                    System.out.println("Файл " + transaction + ",строка" + lineCount +
                                            ": Недостаточно денег для перевода");
                                }
                            } else{
                                System.out.println("Файл " + transaction + ",строка" + lineCount + ": Компания " +
                                        splits[2] + " с лицевым счётом " + splits[3] + " не существует");
                            }
                        } else{
                            System.out.println("Файл " + transaction + ",строка" + lineCount + ": Компания "
                                    + splits[1] + " с лицевым счётом " + splits[0] + " не существует");
                        }
                        lineCount++;
                    }
                } catch (Exception e) {
                    System.out.println("файл " + transaction.getPath() + " не обработан");
                }
                reader.close();
            }
        }
        DecimalFormat df = new DecimalFormat("#########.##");
        DecimalFormat intf = new DecimalFormat("0000");
        result.createNewFile();
        writer.write("Название компании;Лицевой счёт;Баланс\n");
        for (Integer key : companies.keySet()){
            company = companies.get(key);
            writer.append(company.getName() + ";" + company.getAccount() + ";" + company.getBalance() + "\n");
        }
        writer.close();
    }
}
