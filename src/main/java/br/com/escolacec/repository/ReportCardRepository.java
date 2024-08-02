package br.com.escolacec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolacec.models.ReportCard;

public interface ReportCardRepository extends JpaRepository<ReportCard, Long> {
	
}
