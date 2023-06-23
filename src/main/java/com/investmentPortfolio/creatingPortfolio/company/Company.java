package com.investmentPortfolio.creatingPortfolio.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )

    private Long id;
    private String ticker;
    private String name;
    private Double revenuePerShare;
    private Double freeCashFlowPerShare;
    private Double bookValuePerShare;
    private Double capexPerShare;
    private Long time;

    private Integer outstandingShares;
    private Double annualPERatio;
    private Double revenue;
    private Double operatingMargin;
    private Double depreciation;
    private Double netProfit;
    private Double incomeTaxRate;
    private Double longTermDebt;
    private Double equity;
    private Double roic;
    private Double returnOnEquity;
    private Double getReturnOnCapital;


    @Override
    public String toString() {
        return "Company{" +
                "ticker='" + ticker + '\'' +
                ", name='" + name + '\'' +
                ", revenuePerShare=" + revenuePerShare +
                ", freeCashFlowPerShare=" + freeCashFlowPerShare +
                ", bookValuePerShare=" + bookValuePerShare +
                ", capexPerShare=" + capexPerShare +
                ", time=" + time +
                ", outstandingShares=" + outstandingShares +
                ", annualPERatio=" + annualPERatio +
                ", revenue=" + revenue +
                ", operatingMargin=" + operatingMargin +
                ", depreciation=" + depreciation +
                ", netProfit=" + netProfit +
                ", incomeTaxRate=" + incomeTaxRate +
                ", longTermDebt=" + longTermDebt +
                ", equity=" + equity +
                ", roic=" + roic +
                ", returnOnEquity=" + returnOnEquity +
                ", getReturnOnCapital=" + getReturnOnCapital +
                '}';
    }
}
