package org.primefaces.test.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Data
public class ContractItem implements Serializable {
    private String contractItemId;
    private String contractId;
    private String itemName;
    private Double weeklyRate;
    private LocalDate itemStart;
    private LocalDate itemTerminate;
    private LocalDate itemPaidUpto;
    private String itemStatus;

    public String getContractItemId() {return contractItemId;}
    public void setContractItemId(String contractItemId) {this.contractItemId = contractItemId;}
    public String getContractId() {return contractId;}
    public void setContractId(String contractId) {this.contractId = contractId;}
    public String getItemName() {return itemName;}
    public void setItemName(String itemName) {this.itemName = itemName;}
    public Double getWeeklyRate() {return weeklyRate;}
    public void setWeeklyRate(Double weeklyRate) {this.weeklyRate = weeklyRate;}
    public LocalDate getItemStart() {return itemStart;}
    public void setItemStart(LocalDate itemStart) {this.itemStart = itemStart;}
    public LocalDate getItemTerminate() {return itemTerminate;}
    public void setItemTerminate(LocalDate itemTerminate) {this.itemTerminate = itemTerminate;}
    public LocalDate getItemPaidUpto() {return itemPaidUpto;}
    public void setItemPaidUpto(LocalDate itemPaidUpto) {this.itemPaidUpto = itemPaidUpto;}
    public String getItemStatus() {return itemStatus;}
    public void setItemStatus(String itemStatus) {this.itemStatus = itemStatus;}

    public ContractItem() {
        Random rand = new Random();
        StringBuilder idBuilder = new StringBuilder();
        idBuilder.append("ItemId_").append(rand.nextInt(1000));
        this.setContractItemId(idBuilder.toString());
    }
    public ContractItem(String contractItemId, String contractId, String itemName) {
        this.contractItemId = contractItemId;
        this.contractId = contractId;
        this.itemName = itemName;
    }
    public ContractItem(String contractItemId, String contractId, String itemName, Double weeklyRate, LocalDate itemStart, LocalDate itemTerminate, LocalDate itemPaidUpto, String itemStatus) {
        this.contractItemId = contractItemId;
        this.contractId = contractId;
        this.itemName = itemName;
        this.weeklyRate = weeklyRate;
        this.itemStart = itemStart;
        this.itemTerminate = itemTerminate;
        this.itemPaidUpto = itemPaidUpto;
        this.itemStatus = itemStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractItem that = (ContractItem) o;
        return Objects.equals(contractItemId, that.contractItemId) && Objects.equals(contractId, that.contractId) && Objects.equals(itemName, that.itemName) && Objects.equals(weeklyRate, that.weeklyRate) && Objects.equals(itemStart, that.itemStart) && Objects.equals(itemTerminate, that.itemTerminate) && Objects.equals(itemPaidUpto, that.itemPaidUpto) && Objects.equals(itemStatus, that.itemStatus);
    }
    @Override
    public int hashCode() {
        return Objects.hash(contractItemId, contractId, itemName, weeklyRate, itemStart, itemTerminate, itemPaidUpto, itemStatus);
    }
    @Override
    public String toString() {
        return "ContractItem{" +
                "contractItemId='" + contractItemId + '\'' +
                ", contractId='" + contractId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", weeklyRate=" + weeklyRate +
                ", itemStart=" + itemStart +
                ", itemTerminate=" + itemTerminate +
                ", itemPaidUpto=" + itemPaidUpto +
                ", itemStatus='" + itemStatus + '\'' +
                '}';
    }
}