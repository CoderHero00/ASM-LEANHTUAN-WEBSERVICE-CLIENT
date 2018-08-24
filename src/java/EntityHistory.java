/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class EntityHistory {
    private String ID;
    private String Name;
    private String Money;
    private String Fee;
    private String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    

    public EntityHistory(String ID, String Name, String Money, String Fee) {
        this.ID = ID;
        this.Name = Name;
        this.Money = Money;
        this.Fee = Fee;
    }

    public EntityHistory() {
    }
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String Money) {
        this.Money = Money;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String Fee) {
        this.Fee = Fee;
    }
    
}
