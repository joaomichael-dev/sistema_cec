package br.com.escolacec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escolacec.models.ReportCard;
import br.com.escolacec.service.ReportCardService;

@RestController
@RequestMapping("/api/report_card")
public class ReportCardController {
	
	@Autowired
	private ReportCardService reportCardService;
	
	@GetMapping
	public Iterable<ReportCard> getAllReportCards() {
		return reportCardService.getAllReportCards();
	}
	
	@GetMapping("/{id}")
	public Optional<ReportCard> getReportCard(@PathVariable Long id) {
		return reportCardService.getReportCardById(id);
	}
	
	@PostMapping("/new")
	public ReportCard createReportCard(@RequestBody ReportCard reportCard) {
		return reportCardService.saveReportCard(reportCard);
	}
	
	@PutMapping("/update/{id}")
	public ReportCard updateReportCard(@PathVariable Long id, @RequestBody ReportCard reportCard) {
		return reportCardService.updateReportCard(id, reportCard);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteReportCard(@PathVariable Long id) {
		reportCardService.deleteReportCard(id);
	}
	
}
