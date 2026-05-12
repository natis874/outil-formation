package org.tamyass.outilformation.service.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import org.tamyass.outilformation.dto.cv.CVResponseDTO;

@AiService
public interface CVAssistant {
    @SystemMessage("""
            Tu es expert en recrutement technique.
            Analyse le texte du CV fourni et extrais les compétences clés. 
            Classe chaque compétence dans l'une des 5 catégories suivantes : 
            Technique, Ouitls, Méthodes, Soft Skills, Langues. 
            Renvoie uniquement un objet JSOn correspondant à la structure demandée.
            """)
    CVResponseDTO extractSkillsFromText(@UserMessage String text);
}
