package algohub.project.service;

import algohub.project.domain.algorithm.AlgoCategory;
import algohub.project.repository.algorithm.AlgoCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlgoCategoryService {

    private final AlgoCategoryRepository algoCategoryRepository;

    public List<AlgoCategory> getAlgoCategory() {
        return algoCategoryRepository.getAlgoCategory();
    }
}
