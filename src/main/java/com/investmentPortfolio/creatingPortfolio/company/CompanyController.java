package com.investmentPortfolio.creatingPortfolio.company;

import java.util.List;

import com.investmentPortfolio.creatingPortfolio.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/company")
public class CompanyController {
    CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompany() {
        return companyService.getCompany();
    }
    @PostMapping
    public void registerNewCompany(@RequestBody CompanyDTO company){
        companyService.addNewCompany(company, company.getTicker());
    }
@DeleteMapping(path = "{ticker}")
    public void deleteCompany(@PathVariable("ticker") String ticker){
        companyService.deleteCompany(ticker);
}

@PutMapping(path="{id}")
    public void updateCompany(
//        @PathVariable("id") Long id,
        @RequestParam CompanyDTO companyDTO

//                              @RequestParam(required = false) String name,
//                              @RequestParam(required = false)String ticker,
//                              @RequestParam(required = false) Double revenuePerShare,
//                              @RequestParam(required = false)Double freeCashFlowPerShare,
//                              @RequestParam(required = false)Double bookValuePerShare,
//                              @RequestParam(required = false)Double capexPerShare,
//                              @RequestParam(required = false)int outstandingShares,
//                              @RequestParam(required = false)Double annualPERatio,
//                              @RequestParam(required = false)Double revenue,
//                              @RequestParam(required = false) Double operatingMargin,
//                              @RequestParam(required = false)Double depreciation,
//                              @RequestParam(required = false)Double netProfit,
//                              @RequestParam(required = false)Double incomeTaxRate,
//                              @RequestParam(required = false)Double longTermDebt,
//                              @RequestParam(required = false)Double equity,
//                              @RequestParam(required = false)Double roic,
//                              @RequestParam(required = false)Double returnOnEquity,
//                              @RequestParam(required = false)Double getReturnOnCapital
){
        companyService.updateCompany( companyDTO);
}
}
