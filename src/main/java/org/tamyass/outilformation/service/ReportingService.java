package org.tamyass.outilformation.service;

import org.tamyass.outilformation.dto.report.MindMapDTO;
import org.tamyass.outilformation.dto.report.TextReportDTO;

import java.util.List;

public interface ReportingService {

    List<MindMapDTO> getMindMap(Long userId);
    TextReportDTO getTextReport(Long userId);

}
