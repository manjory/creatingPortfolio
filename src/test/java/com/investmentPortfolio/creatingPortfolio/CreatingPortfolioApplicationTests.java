package com.investmentPortfolio.creatingPortfolio;

import com.investmentPortfolio.creatingPortfolio.company.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest
class CreatingPortfolioApplicationTests {


	@Test
	void testupdateCompanyId() {
		CompanyDTO dto = new CompanyDTO();
		long id = 1234l;
		dto.setId(id);
		CompanyService service = new CompanyService();

//		service.updateCompany(dto);



	}

}
