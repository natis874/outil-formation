package org.tamyass.outilformation.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
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

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor // pour injecter proprement des repositories et mappers
@Slf4j
public class CVServiceImpl implements CVService {

    private final SkillRepository skillRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final SkillMapper skillMapper;
    private final CVAssistant cvAssistant; // injecté automatiquement par LangChain4j

    @Override
    public CVResponseDTO extractSkillFromCV(MultipartFile multipartFile) {
        try {
            //Extraire le texte selon le type de fichier
            String content = convertFileToText(multipartFile);
            // Envoyer le texte à LangChain4j
            return cvAssistant.extractSkillsFromText(content);
        }catch (Exception e){
            log.error("Erreur lors de la lecture du fichier CV",e);
            throw new RuntimeException("Impossible de lire le fichier fourni");
        }
        // String cvText = convertFileToText(file);
        // var mockSkills = List.of(new CVSkillDTO("Java 21","Technique"),new CVSkillDTO("Docker","Outils"),new CVSkillDTO("Scrum","Méthodes"));
        // return CVResponseDTO.builder().skills(mockSkills).build();
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

    private String convertFileToText(MultipartFile file) throws IOException{
        String contentType = file.getContentType();
        if (contentType != null && contentType.contains("pdf")) {
            try (PDDocument document = Loader.loadPDF(file.getBytes())) {
                return new PDFTextStripper().getText(document);
            }
        } else if (contentType != null && (contentType.contains("word") || contentType.contains("officedocument"))) {
            try (XWPFDocument docx = new XWPFDocument(file.getInputStream())) {
                XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
                return extractor.getText();
            }
        }
        throw new IllegalArgumentException("Format de fichier non supporté. Utilisez PDF ou DOCX.");
    }


}
