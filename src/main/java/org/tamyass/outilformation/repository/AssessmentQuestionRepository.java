package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tamyass.outilformation.entities.AssessmentQuestion;
@Repository
public interface AssessmentQuestionRepository extends JpaRepository<AssessmentQuestion,Long> {
}
