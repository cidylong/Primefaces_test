package com.longz.test.view;

import com.longz.test.model.Contract;
import com.longz.test.model.ContractPack;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Named
@ViewScoped
public class ContractPackTabView implements Serializable {
    private ContractPack contractPack;
    private Boolean contractEditViewMode;
    private Boolean contractItemEditViewMode;

    public ContractPack getContractPack() {return contractPack;}
    public void setContractPack(ContractPack contractPack) {this.contractPack = contractPack;}
    public Boolean getContractEditViewMode() {return contractEditViewMode;}
    public void setContractEditViewMode(Boolean contractEditViewMode) {this.contractEditViewMode = contractEditViewMode;}
    public Boolean getContractItemEditViewMode() {return contractItemEditViewMode;}
    public void setContractItemEditViewMode(Boolean contractItemEditViewMode) {this.contractItemEditViewMode = contractItemEditViewMode;}

    @PostConstruct
    public void init() {
        contractEditViewMode = false;
        contractItemEditViewMode = false;
        Contract contract = new Contract("contractId-1","hostId_1","PayerId_1","Contract about chairs hire.",
                LocalDate.now(),LocalDate.now().plusMonths(2),40.00,"New");
        contractPack = new ContractPack(contract);
    }
    public void onTabChange(TabChangeEvent event){
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void onTabClose(TabCloseEvent event){
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
