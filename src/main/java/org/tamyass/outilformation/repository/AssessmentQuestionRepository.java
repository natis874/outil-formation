package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tamyass.outilformation.entities.AssessmentQuestion;

import java.util.List;

@Repository
public interface AssessmentQuestionRepository extends JpaRepository<AssessmentQuestion,Long> {

    List<AssessmentQuestion> findAssessmentQuestionBySkillId(Long skillId);
    void deleteAssessmentQuestionBySkillId(Long skillId);

}
