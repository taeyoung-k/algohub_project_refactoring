package algohub.project.controller.unit.algorithm;

import algohub.project.config.EnableMockMvc;
import algohub.project.controller.algorithm.AlgorithmController;
import algohub.project.controller.algorithm.dto.AlgoListDto;
import algohub.project.repository.algorithm.AlgorithmRepository;
import algohub.project.service.AlgorithmService;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@EnableMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(AlgorithmController.class)
public class AlgorithmControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AlgorithmService algorithmService;

    @MockBean
    private AlgorithmRepository algorithmRepository;

    @Test
    @DisplayName("알고리즘 문제 조회 컨트롤러 단위테스트")
    void test() throws Exception {

        String categoryId = "1";
        List<AlgoListDto> algoListDtoList = new ArrayList<>();
        algoListDtoList.add(AlgoListDto.builder()
                .p_title("테스트")
                .p_category("그래프")
                .p_link("www.xxx.com")
                .p_number(0)
                .a_id(1)
                .language("Java")
                .build());

        given(algorithmService.getAlgoList(categoryId)).willReturn(algoListDtoList);

        Gson gson = new Gson();
        String result = gson.toJson(algoListDtoList);

        System.out.println("result = " + result);
        mvc.perform(MockMvcRequestBuilders.get("/api/algorithms/" + categoryId).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(result))
                .andDo(MockMvcResultHandlers.print());
    }
}
