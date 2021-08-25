package algohub.project.controller.algorithm;

import algohub.project.controller.algorithm.dto.AlgoListDto;
import algohub.project.service.AlgorithmService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/algorithms")
public class AlgorithmController {

    private final AlgorithmService algorithmService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{a_c_id}")
    public ResponseEntity<List<AlgoListDto>> algorithms(@PathVariable("a_c_id") String categoryId) {
        // 사용자 추가 하면
        UUID uuid = UUID.randomUUID();
        logger.info("알고리즘 문제 조회 컨트롤러 실행 {}, 카테고리 id {}", uuid, categoryId);

        List<AlgoListDto> response = algorithmService.getAlgoList(categoryId);

        return new ResponseEntity<List<AlgoListDto>>(response, HttpStatus.OK);
    }
}
