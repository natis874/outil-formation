package org.tamyass.outilformation.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tamyass.outilformation.dto.AssessmentQuestionDTO;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.service.AssessmentQuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class AssessmentRestController {
    private final AssessmentQuestionService assessmentQuestionService;

    public AssessmentRestController(AssessmentQuestionService assessmentQuestionService) {
        this.assessmentQuestionService = assessmentQuestionService;
    }
    @PostMapping("/{skillId}/assessment/start")
    public ResponseEntity<List<AssessmentQuestionDTO>> startAssessment(@PathVariable Long skillId){
        return ResponseEntity.ok(assessmentQuestionService.generateQuestionBySkillId(skillId));
    }
    @GetMapping("/{skillId}/questions")
    public ResponseEntity<List<AssessmentQuestionDTO>> getQuestions(@PathVariable Long skillId){
        return ResponseEntity.ok(assessmentQuestionService.getQuestionsBySkillId(skillId));
    }
    @PostMapping("/{skillId}/assessment/submit")
    public ResponseEntity<SkillDTO> submitAssessment(@PathVariable Long skillId,@RequestBody List<AssessmentQuestionDTO> answers){
        return ResponseEntity.ok(assessmentQuestionService.submitAassessment(skillId,answers));
    }


}
