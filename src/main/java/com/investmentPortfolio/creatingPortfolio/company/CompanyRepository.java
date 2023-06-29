package com.investmentPortfolio.creatingPortfolio.company;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    @Query("SELECT c FROM Company c WHERE c.ticker= ?1")
    Optional<Company> findCompanyByTicker(String ticker);
}
