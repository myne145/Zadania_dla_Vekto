package Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    private static final int zeroPercent = 144; //0% is 144$


    private static void zad1() throws IOException {
        double profits = 0;
        final ArrayList<String> fileContent = (ArrayList<String>) Files.readAllLines(new File("dane.txt").toPath());
        for(String s : fileContent) {
            double percentage = Double.parseDouble(s.split("\t")[2]) / 100;
            if(percentage < 0) {
                double percentageAbs = Math.abs(percentage);
                profits -= (percentageAbs * zeroPercent);
            } else if(percentage > 0) {
                profits += (percentage * zeroPercent);
            } else { //equal to 0
                profits += zeroPercent;
            }
        }
        System.out.println(profits);
    }


    private static final DecimalFormat decimalFormat = new DecimalFormat("##.##");
    private static void zad2() throws IOException {
        ArrayList<String> content = (ArrayList<String>) Files.readAllLines(new File("dane2.txt").toPath());
        double averageYear;
        double temp = 1;
        System.out.println("Year\tGrowth(%)");
        for(String s : content) {
            String[] lineSplitted = s.split("\t");
            if(lineSplitted[1].equals("12")) {
                averageYear = temp / Double.parseDouble(lineSplitted[3]);
                if(averageYear * 100 - 100 > 0)
                    System.out.println(lineSplitted[0] + "\t+" + decimalFormat.format(averageYear * 100 - 100) + "%");
                else
                    System.out.println(lineSplitted[0] + "\t" + decimalFormat.format(averageYear * 100 - 100)  + "%");
            } else if(lineSplitted[1].equals("1")){
                temp = Double.parseDouble(lineSplitted[3]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        zad1();
        zad2();

    }
}