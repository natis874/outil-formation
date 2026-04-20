package org.tamyass.outilformation.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tamyass.outilformation.dto.report.MindMapDTO;
import org.tamyass.outilformation.dto.report.TextReportDTO;
import org.tamyass.outilformation.service.ReportingService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportingRestController {
    private final ReportingService reportingService;
    public ReportingRestController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }
    @GetMapping("/text/user/{userId}")
    public ResponseEntity<TextReportDTO> getTextReport(@PathVariable  Long userId) {
        return ResponseEntity.ok(reportingService.getTextReport(userId));
    }

    @GetMapping("/mindmap/user/{userId}")
    public ResponseEntity<List<MindMapDTO>> getMindMap(@PathVariable Long userId) {
        return ResponseEntity.ok(reportingService.getMindMap(userId));
    }

}
