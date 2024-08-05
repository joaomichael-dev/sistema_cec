package br.com.escolacec.service;

import br.com.escolacec.models.ReportCard;
import br.com.escolacec.repository.ReportCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportCardService {

    @Autowired
    private ReportCardRepository reportCardRepository;

    public ReportCard saveReportCard(ReportCard reportCard) {
        return reportCardRepository.save(reportCard);
    }

    public Optional<ReportCard> getReportCardById(Long id) {
        return reportCardRepository.findById(id);
    }

    public Iterable<ReportCard> getAllReportCards() {
        return reportCardRepository.findAll();
    }

    public ReportCard updateReportCard(Long id, ReportCard reportCard) {
        Optional<ReportCard> existingReportCard = reportCardRepository.findById(id);
        if (existingReportCard.isPresent()) {
            ReportCard updatedReportCard = existingReportCard.get();
            updatedReportCard.setStudent(reportCard.getStudent());
            updatedReportCard.setTurma(reportCard.getTurma());
            updatedReportCard.setNota(reportCard.getNota());
            updatedReportCard.setComentarios(reportCard.getComentarios());
            return reportCardRepository.save(updatedReportCard);
        } else {
            throw new RuntimeException("ReportCard not found with id " + id);
        }
    }

    public void deleteReportCard(Long id) {
        reportCardRepository.deleteById(id);
    }
}
