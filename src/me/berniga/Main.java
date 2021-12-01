package me.berniga;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void fillProducts(Shop s){
        String[] tempNames={"insalata","pomodori","carote","verza","zucchine","porro","mela","pera","banana","mirtilli","pesca","limone"};
        for(int i=0;i<12;i++){
            if(i>5)
                s.addProduct(i,new Product(tempNames[i],"fruit",(new Random().nextDouble()+new Random().nextInt(5))));
            else
                s.addProduct(i,new Product(tempNames[i],"vegetables",(new Random().nextDouble()+new Random().nextInt(5))));
        }
    }
    public static void showProducts(Cart c){
        for(int i=0;i<c.getProductsLength();i++)
            if(c.getProduct(i)!=null)
                System.out.println(c.getProduct(i).toString());
    }
    public static void showByCategory(Cart c,String category){
        System.out.println("These are all the "+category+" that you have in the cart");
        for(int i=0;i<c.getProductsLength();i++)
            if(c.getProduct(i)!=null&&c.getProduct(i).getCategory().equalsIgnoreCase(category))
                System.out.println(c.getProduct(i).toString());
    }
    public static void main(String[] args) {
        Shop s1=new Shop("Iperal","Castione (SO)");
        Cart c1=new Cart("Giorgio");
        LocalTime t=LocalTime.now();
        fillProducts(s1);
        c1.addProduct(new Product("insalata","vegetable",  new BigDecimal(new Random().nextDouble()+new Random().nextInt(5)).setScale(2,RoundingMode.HALF_UP).doubleValue()));
        t=LocalTime.now();
        System.out.println("("+t.getHour()+":"+t.getMinute()+":"+t.getSecond()+") a new product is put in the cart");
        c1.addProduct(new Product("filetto","meat",new BigDecimal(new Random().nextDouble()+new Random().nextInt(5)).setScale(2,RoundingMode.HALF_UP).doubleValue()));
        t=t.plusHours(2);
        System.out.println("("+t.getHour()+":"+t.getMinute()+":"+t.getSecond()+") a new product is put in the cart");
        c1.addProduct(new Product("mela","fruit",new BigDecimal(new Random().nextDouble()+new Random().nextInt(5)).setScale(2,RoundingMode.HALF_UP).doubleValue()));
        t=LocalTime.parse("13:10:01");
        System.out.println("("+t.getHour()+":"+t.getMinute()+":"+t.getSecond()+") a new product is put in the cart");
        showProducts(c1);
        System.out.println("Total price of "+c1.getOwnerName()+": "+c1.getTotalPrice());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        c1.removeProduct(1);
        showProducts(c1);
        System.out.println("Total price of "+c1.getOwnerName()+": "+new BigDecimal(c1.getTotalPrice()).setScale(2,RoundingMode.HALF_UP).doubleValue());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        c1.addProduct(new Product("carote","vegetable",new BigDecimal(new Random().nextDouble()+new Random().nextInt(5)).setScale(2,RoundingMode.HALF_UP).doubleValue()));
        c1.addProduct(new Product("prosciutto","meat",new BigDecimal(new Random().nextDouble()+new Random().nextInt(5)).setScale(2,RoundingMode.HALF_UP).doubleValue()));
        c1.addProduct(new Product("pesca","fruit",new BigDecimal(new Random().nextDouble()+new Random().nextInt(5)).setScale(2,RoundingMode.HALF_UP).doubleValue()));
        c1.addProduct(new Product("melone","fruit",new BigDecimal(new Random().nextDouble()+new Random().nextInt(5)).setScale(2,RoundingMode.HALF_UP).doubleValue()));
        showProducts(c1);
        System.out.println("Total price of "+c1.getOwnerName()+": "+new BigDecimal(c1.getTotalPrice()).setScale(2,RoundingMode.HALF_UP).doubleValue());
        System.out.println("-------------------------------------------------------------------------------------------------------");
        showByCategory(c1,"vegetable");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        showByCategory(c1,"meat");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}
