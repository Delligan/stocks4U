/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Char
 * 
 * 20nnnnnvncxv vn v vv v v  -dell
 */
public final class Stock
{
    //initialize variables
    private String companyName; 
    private double numberofShares;
    private double purchasePrice;
    private double currentPrice;
 
    //constructors 
    public Stock(){
        companyName = "N/A";
        numberofShares = 0;
        purchasePrice = 0.0;
        currentPrice = 0.0;
    }
    
    public Stock(String companyName, double numberofShares, double purchasePrice, double currentPrice)
    {
       this.setCompanyName(companyName);
       this.setNumberofShares(numberofShares);
       setCurrentPrice(currentPrice);
       setPurchasePrice(purchasePrice);      
    }
    //getters and setter
    @Override
    public String toString()
    {
        //"Company: qty shares"
        return companyName + " " + numberofShares + " shares";
    }
    //behaviors
    public double getProfitLoss(){
        return numberofShares * (currentPrice - purchasePrice);    
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public double getNumberofShares()
    {
        return numberofShares;
    }

    public void setNumberofShares(double numberofShares)
    {
        //validation
        if (numberofShares > 0 )
            this.numberofShares = numberofShares; //have there been any shares bought 
        else
            this.numberofShares = 0.0;//if no then number of shares is 0.0
        
    }

    public double getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice)
    {
        if (purchasePrice < 0)
            this.purchasePrice = purchasePrice;
        else
            this.purchasePrice = 0.0;
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice)
    {
        this.currentPrice = currentPrice;
    }
    
    

    
    
    
 
 
}
