package algohub.project.controller.algorithm;


import algohub.project.domain.algorithm.AlgoCategory;
import algohub.project.service.AlgoCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * API 1번 알고리즘 분류 목록
 * 작성자 : 김태영 (2021-04-18)
 * 내용 : 알고리즘 카테고리
 */
@RequiredArgsConstructor
@RestController
public class AlgoCategoryController {

    private final AlgoCategoryService algoCategoryService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/api/categories")
    public ResponseEntity<List<AlgoCategory>> algoCategory() {
        // 사용자 추가 하면
        UUID uuid = UUID.randomUUID();
        logger.info("알고리즘 카테고리 컨트롤러 실행 : {}", uuid);

        List<AlgoCategory> response = algoCategoryService.getAlgoCategory();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
