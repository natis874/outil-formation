package org.tamyass.outilformation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tamyass.outilformation.dto.SkillDTO;
import org.tamyass.outilformation.dto.cv.CVResponseDTO;
import org.tamyass.outilformation.dto.cv.CVSkillDTO;
import org.tamyass.outilformation.entities.Category;
import org.tamyass.outilformation.entities.Skill;
import org.tamyass.outilformation.entities.User;
import org.tamyass.outilformation.mapper.SkillMapper;
import org.tamyass.outilformation.repository.CategoryRepository;
import org.tamyass.outilformation.repository.SkillRepository;
import org.tamyass.outilformation.repository.UserRepository;
import org.tamyass.outilformation.service.CVService;
import org.tamyass.outilformation.service.ai.CVAssistant;

import java.util.List;
@Service
@RequiredArgsConstructor // pour injecter proprement des repositories et mappers
public class CVServiceImpl implements CVService {

    private final SkillRepository skillRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final SkillMapper skillMapper;
    private final CVAssistant cvAssistant; // inhjecté automqtiquement par LangChain4j

    @Override
    public CVResponseDTO extractSkillFromCV(MultipartFile multipartFile) {
        //TODO Ajouter ici la logique de parsing + Appel LangChain4J
        //String cvText = convertFileToText(file);
        var mockSkills = List.of(new CVSkillDTO("Java 21","Technique"),new CVSkillDTO("Docker","Outils"),new CVSkillDTO("Scrum","Méthodes"));
        return CVResponseDTO.builder().skills(mockSkills).build();
    }
    private String convertFileToText(MultipartFile file){
        return null;
    }

    @Override
    public List<SkillDTO> saveSkills(Long userId, List<CVSkillDTO> skills) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        List<Skill> skillsToSave = skills.stream().map(dto -> {
            Category category = categoryRepository.findByName(dto.getCategoryName())
                    .orElseGet(() ->
                            categoryRepository.save(
                                    Category.builder().name(dto.getCategoryName()).build()
                            )
                    );
            return Skill.builder()
                    .name(dto.getName())
                    .category(category)
                    .user(user)
                    .selfLevel(1)
                    .build();
        }).toList();

        return skillRepository.saveAll(skillsToSave)
                .stream()
                .map(skillMapper::toDTO)
                .toList();
    }
}
