package co.yuno.n8nService.service;

import co.yuno.n8nService.persistence.entity.Procesed;
import co.yuno.n8nService.persistence.repository.ProcesedRepository;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class ProcesedCompareService {

    private final ProcesedRepository procesedRepository;
    private final OpenAiService openAiService;

    public ProcesedCompareService(ProcesedRepository procesedRepository) {
        this.procesedRepository = procesedRepository;
        // Leés la API key desde variable de entorno o properties
        this.openAiService = new OpenAiService(System.getenv("OPENAI_API_KEY"), Duration.ofSeconds(30));
    }

    public String compararYResumir(Integer id1, Integer id2) {
        Procesed p1 = procesedRepository.findById(id1)
                .orElseThrow(() -> new IllegalArgumentException("No existe procesed id=" + id1));
        Procesed p2 = procesedRepository.findById(id2)
                .orElseThrow(() -> new IllegalArgumentException("No existe procesed id=" + id2));

        String prompt = crearPromptComparacion(p1, p2);

        var completion = openAiService.createChatCompletion(builder -> builder
                .model("gpt-4o-mini")
                .addMessage("system", "Eres un asistente que compara registros de base de datos y responde en español de forma breve.")
                .addMessage("user", prompt)
        );

        return completion.getChoices().get(0).getMessage().getContent();
    }

    private String crearPromptComparacion(Procesed p1, Procesed p2) {
        return """
                Compara los siguientes dos registros `Procesed` y genera:
                - Un resumen breve en español de las diferencias clave.
                - En qué se parecen.

                Registro 1:
                id: %d
                phase: %s
                projectName: %s
                detailType: %s
                summary: %s
                detail: %s

                Registro 2:
                id: %d
                phase: %s
                projectName: %s
                detailType: %s
                summary: %s
                detail: %s
                """
                .formatted(
                        p1.getIdProcesed(), p1.getPhase(), p1.getProjectName(), p1.getDetailType(), p1.getSummary(), p1.getDetail(),
                        p2.getIdProcesed(), p2.getPhase(), p2.getProjectName(), p2.getDetailType(), p2.getSummary(), p2.getDetail()
                );
    }
}
