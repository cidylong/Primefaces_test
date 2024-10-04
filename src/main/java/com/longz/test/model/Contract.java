package com.longz.test.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
@Data
public class Contract implements Serializable {
    private String contractId;
    private String contractHostId;
    private String contractHolderId;
    private String contractContent;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Double contractedRate;
    private String status;

    public String getContractId() {return contractId;}
    public void setContractId(String contractId) {this.contractId = contractId;}
    public String getContractHostId() {return contractHostId;}
    public void setContractHostId(String contractHostId) {this.contractHostId = contractHostId;}
    public String getContractHolderId() {return contractHolderId;}
    public void setContractHolderId(String contractHolderId) {this.contractHolderId = contractHolderId;}
    public String getContractContent() {return contractContent;}
    public void setContractContent(String contractContent) {this.contractContent = contractContent;}
    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}
    public LocalDate getFinishDate() {return finishDate;}
    public void setFinishDate(LocalDate finishDate) {this.finishDate = finishDate;}
    public Double getContractedRate() {return contractedRate;}
    public void setContractedRate(Double contractedRate) {this.contractedRate = contractedRate;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public Contract() {}
    public Contract(String contractId, String contractHostId, String contractHolderId) {
        this.contractId = contractId;
        this.contractHostId = contractHostId;
        this.contractHolderId = contractHolderId;
    }
    public Contract(String contractId, String contractHostId, String contractHolderId, String contractContent, LocalDate startDate, LocalDate finishDate, Double contractedRate, String status) {
        this.contractId = contractId;
        this.contractHostId = contractHostId;
        this.contractHolderId = contractHolderId;
        this.contractContent = contractContent;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.contractedRate = contractedRate;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(contractId, contract.contractId) && Objects.equals(contractHostId, contract.contractHostId) && Objects.equals(contractHolderId, contract.contractHolderId) && Objects.equals(contractContent, contract.contractContent) && Objects.equals(startDate, contract.startDate) && Objects.equals(finishDate, contract.finishDate) && Objects.equals(contractedRate, contract.contractedRate) && Objects.equals(status, contract.status);
    }
    @Override
    public int hashCode() {
        return Objects.hash(contractId, contractHostId, contractHolderId, contractContent, startDate, finishDate, contractedRate, status);
    }
    @Override
    public String toString() {
        return "Contract{" +
                "contractId='" + contractId + '\'' +
                ", contractHostId='" + contractHostId + '\'' +
                ", contractHolderId='" + contractHolderId + '\'' +
                ", contractContent='" + contractContent + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", contractedRate=" + contractedRate +
                ", status='" + status + '\'' +
                '}';
    }
}
