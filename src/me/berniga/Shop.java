package me.berniga;

public class Shop {
    private String name;
    private String location;
    private Product[] products;

    public Shop(String name,String location){
        this.name=name;
        this.location=location;
        products=new Product[12];
    }

    private boolean isFree(int i){
        return products[i]==null;
    }

    private int firstFree(){
        for(int i=0;i<products.length;i++){
            if(products[i]==null)
                return i;
        }
        increaseShop();
        return firstFree();
    }

    public void increaseShop(){
        Product[] newShop=new Product[products.length+1];
        for(int i=0;i< products.length;i++)
            newShop[i]=products[i];
        products=newShop;
    }

    public void addProduct(int i,Product p){
        if(isFree(i))
            products[i]=p;
        else
            products[firstFree()]=p;
    }

    public void removeProduct(int i){
        if(!isFree(i))
            products[i]=null;
    }






}
