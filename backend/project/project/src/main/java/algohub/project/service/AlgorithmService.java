package algohub.project.service;

import algohub.project.controller.algorithm.dto.AlgoListDto;
import algohub.project.repository.algorithm.AlgorithmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlgorithmService {

    private final AlgorithmRepository algorithmRepository;

    public List<AlgoListDto> getAlgoList(String categoryId) {
        return  algorithmRepository.getAlgoList(categoryId);
    }
}
