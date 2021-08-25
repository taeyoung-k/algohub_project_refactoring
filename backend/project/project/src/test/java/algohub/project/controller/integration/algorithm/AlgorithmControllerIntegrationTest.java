package algohub.project.controller.integration.algorithm;

import algohub.project.config.EnableMockMvc;
import algohub.project.controller.algorithm.dto.AlgoListDto;
import algohub.project.repository.algorithm.AlgorithmRepository;
import algohub.project.service.AlgorithmService;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


@EnableMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AlgorithmControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AlgorithmService algorithmService;

    @Autowired
    private AlgorithmRepository algorithmRepository;

    @Test
    @DisplayName("알고리즘 문제 조회 컨트롤러 통합테스트")
    void test() throws Exception {
        //given
        // 사용자가 추가되어야 함

        //when
        Gson gson = new Gson();
        String categoryId = "1";
        List<AlgoListDto> algoList = algorithmService.getAlgoList(categoryId);
        String result = gson.toJson(algoList);

        //then
        mvc.perform(MockMvcRequestBuilders.get("/api/algorithms/" + categoryId).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(result))
                .andDo(MockMvcResultHandlers.print());
    }
}
