package com.longz.test.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
@Data
public class ContractPack implements Serializable {
    private Contract contract;
    private Set<ContractItem> contractItemSet;
    private ContractItem currentItem;

    public Contract getContract() {return contract;}
    public void setContract(Contract contract) {this.contract = contract;}
    public Set<ContractItem> getContractItemSet() {return contractItemSet;}
    public void setContractItemSet(Set<ContractItem> contractItemSet) {this.contractItemSet = contractItemSet;}
    public ContractItem getCurrentItem() {return currentItem;}
    public void setCurrentItem(ContractItem currentItem) {this.currentItem = currentItem;}

    public ContractPack() {}
    public ContractPack(Contract contract) {
        this.contract = contract;
    }
    public ContractPack(Contract contract, Set<ContractItem> contractItemSet, ContractItem currentItem) {
        this.contract = contract;
        this.contractItemSet = contractItemSet;
        this.currentItem = currentItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractPack that = (ContractPack) o;
        return Objects.equals(contract, that.contract) && Objects.equals(contractItemSet, that.contractItemSet) && Objects.equals(currentItem, that.currentItem);
    }
    @Override
    public int hashCode() {
        return Objects.hash(contract, contractItemSet, currentItem);
    }
    @Override
    public String toString() {
        return "ContractPack{" +
                "contract=" + contract +
                ", contractItemSet=" + contractItemSet +
                ", currentItem=" + currentItem +
                '}';
    }
    public ContractItem createContractItemFormPack(){
        ContractItem returnItem = new ContractItem();
        if(getContract()!=null && getContract().getContractId()!=null){
            returnItem.setContractId(getContract().getContractId());
        }
        return returnItem;
    }
    public void addItem(ContractItem cItem){
        if(!contractItemSet.isEmpty()){
            java.util.function.Predicate<ContractItem> prn = (ContractItem c) -> c.getContractItemId().equalsIgnoreCase(cItem.getContractItemId());
            contractItemSet.removeIf(prn);
            contractItemSet.add(cItem);
        }else {
            contractItemSet.add(cItem);
        }
    }
    public void accessContractItemFromPackById(String itemId){
        setCurrentItem(contractItemSet.stream().filter(c->c.getContractItemId().equalsIgnoreCase(itemId)).findAny().orElse(null));
    }
}
