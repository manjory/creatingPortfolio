package com.investmentPortfolio.creatingPortfolio.company;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.investmentPortfolio.creatingPortfolio.CompanyDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public CompanyService() {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompany() {
        return companyRepository.findAll();

    }

    public void addNewCompany(CompanyDTO companyDto, String ticker) {
        Optional<Company> companyByTicker = companyRepository.findCompanyByTicker(companyDto.getTicker());
        if (companyByTicker.isPresent()) {
            throw new IllegalStateException("ticket taken");
        }
        Company company =  new Company();
        BeanUtils.copyProperties(companyDto, company);
        companyRepository.save(company);
    }

    public void deleteCompany(String ticker) {
        boolean exists = companyRepository.existsById(ticker);
        if (!exists) {
            throw new IllegalStateException("company with ticker=" + ticker + " doesnt exist");
        }
        companyRepository.deleteById(ticker);
    }

    @Transactional
    public Company updateCompany(CompanyDTO companyDTO) {

        Company company = companyRepository.findById(String.valueOf(companyDTO.getId())).orElseThrow(() ->
                new IllegalStateException("company with ticker=" + companyDTO.getId() + " doesnt exist"));
        if (companyDTO.getName() != null && companyDTO.getName().length() > 0 && !Objects.equals(company.getName(), companyDTO.getName())) {
            company.setName(companyDTO.getName());
        }
        if (companyDTO.getTicker() != null && companyDTO.getTicker().length() > 0 && !Objects.equals(company.getName(), companyDTO.getTicker())) {
            company.setTicker(companyDTO.getTicker());
        }
        if (companyDTO.getRevenuePerShare() == 0 || !Objects.equals(company.getRevenuePerShare(), companyDTO.getRevenuePerShare())) {
            company.setRevenuePerShare(companyDTO.getRevenuePerShare());
        }
        if (companyDTO.getFreeCashFlowPerShare() == 0 || !Objects.equals(company.getFreeCashFlowPerShare(), companyDTO.getFreeCashFlowPerShare())) {
            company.setFreeCashFlowPerShare(companyDTO.getFreeCashFlowPerShare());
        }
        if (companyDTO.getBookValuePerShare() == 0 || !Objects.equals(company.getBookValuePerShare(), companyDTO.getBookValuePerShare())) {
            company.setBookValuePerShare(companyDTO.getBookValuePerShare());
        }
        if (companyDTO.getCapexPerShare() == 0 || !Objects.equals(company.getCapexPerShare(), companyDTO.getCapexPerShare())) {
            company.setCapexPerShare(companyDTO.getCapexPerShare());
        }
        if (companyDTO.getOutstandingShares() == 0 || !Objects.equals(company.getOutstandingShares(), companyDTO.getOutstandingShares())) {
            company.setOutstandingShares(companyDTO.getOutstandingShares());
        }
        if (companyDTO.getAnnualPERatio() == 0 || !Objects.equals(company.getAnnualPERatio(), companyDTO.getAnnualPERatio())) {
            company.setAnnualPERatio(companyDTO.getAnnualPERatio());
        }
        if (companyDTO.getRevenue() == 0 || !Objects.equals(company.getRevenue(), companyDTO.getRevenue() )) {
            company.setRevenue(companyDTO.getRevenue() );
        }
        if (companyDTO.getOperatingMargin() == 0 || !Objects.equals(company.getOperatingMargin(), companyDTO.getOperatingMargin())) {
            company.setOperatingMargin(companyDTO.getOperatingMargin());
        }
        if (companyDTO.getDepreciation() == 0 || !Objects.equals(company.getDepreciation(), companyDTO.getDepreciation())) {
            company.setDepreciation(companyDTO.getDepreciation());
        }
        if (companyDTO.getNetProfit() == 0 || !Objects.equals(company.getNetProfit(), companyDTO.getNetProfit())) {
            company.setNetProfit(companyDTO.getNetProfit());
        }
        if (companyDTO.getIncomeTaxRate() == 0 || !Objects.equals(company.getIncomeTaxRate(), companyDTO.getIncomeTaxRate())) {
            company.setIncomeTaxRate(companyDTO.getIncomeTaxRate());
        }
        if (companyDTO.getLongTermDebt() == 0 || !Objects.equals(company.getLongTermDebt(), companyDTO.getLongTermDebt())) {
            company.setLongTermDebt(companyDTO.getLongTermDebt());
        }
        if (companyDTO.getEquity() == 0 || !Objects.equals(company.getEquity(), companyDTO.getEquity())) {
            company.setEquity(companyDTO.getEquity());
        }
        if (companyDTO.getRoic() == 0 || !Objects.equals(company.getRoic(), companyDTO.getRoic())) {
            company.setRoic(companyDTO.getRoic());
        }
        if (companyDTO.getReturnOnEquity() == 0 || !Objects.equals(company.getReturnOnEquity(), companyDTO.getReturnOnEquity())) {
            company.setReturnOnEquity(companyDTO.getReturnOnEquity());
        }
        if (companyDTO.getGetReturnOnCapital() == 0 || !Objects.equals(company.getGetReturnOnCapital(), companyDTO.getGetReturnOnCapital())) {
            company.setGetReturnOnCapital(companyDTO.getGetReturnOnCapital());
        }
//        if (companyDTO.getTime()!=null){
////            company.setTime(companyDTO.getTime().toEpochSecond());
            company.setTime(System.currentTimeMillis());
//        }
        return company;

    }
}
