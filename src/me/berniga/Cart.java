package me.berniga;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Cart {
    private String ownerName;
    private Product[] products;
    private double totalPrice;

    public Cart(String ownerName){
        this.ownerName=ownerName;
        this.totalPrice=0.0d;
        products=new Product[5];
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Product getProduct(int i) {
        try{return products[i];}
        catch(IndexOutOfBoundsException e){
            System.out.println("PRODOTTO INESISTENTE!!");
            return null;
        }
    }
    public int getProductsLength() {return products.length;}

    private boolean isFree(int i){
        return products[i]==null;
    }
    private int firstFree(){
        for(int i=0;i<products.length;i++){
            if(products[i]==null)
                return i;
        }
        return -1;
    }

    public void addProduct(Product p){
        try{
            products[firstFree()]=p;
            this.totalPrice+=p.getPrice();
        }
        catch(IndexOutOfBoundsException e){ System.out.println("YOUR CART IS FULL !!");}
    }

    public void removeProduct(int i){
        if(!isFree(i)){
            this.totalPrice-=products[i].getPrice();
            products[i]=null;
        }

    }
}
