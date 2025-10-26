package portfolio.model;

import java.io.Serializable;

public class Company implements Serializable {
    private String name;
    private double investmentAmount;
    private int sharesOwned;
    private double returnPercent;
    private String sector;

    public Company(String name, double investmentAmount, int sharesOwned, double returnPercent, String sector) {
        this.name = name;
        this.investmentAmount = investmentAmount;
        this.sharesOwned = sharesOwned;
        this.returnPercent = returnPercent;
        this.sector = sector;
    }

    public String getName() { return name; }
    public double getInvestmentAmount() { return investmentAmount; }
    public int getSharesOwned() { return sharesOwned; }
    public double getReturnPercent() { return returnPercent; }
    public String getSector() { return sector; }

    public void setName(String name) { this.name = name; }
    public void setInvestmentAmount(double investmentAmount) { this.investmentAmount = investmentAmount; }
    public void setSharesOwned(int sharesOwned) { this.sharesOwned = sharesOwned; }
    public void setReturnPercent(double returnPercent) { this.returnPercent = returnPercent; }
    public void setSector(String sector) { this.sector = sector; }
}
