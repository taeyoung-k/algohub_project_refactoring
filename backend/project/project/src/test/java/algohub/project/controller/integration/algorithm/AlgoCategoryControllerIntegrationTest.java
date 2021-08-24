package algohub.project.controller.integration.algorithm;

import algohub.project.config.EnableMockMvc;
import algohub.project.domain.algorithm.AlgoCategory;
import algohub.project.repository.algorithm.AlgoCategoryRepository;
import algohub.project.service.AlgoCategoryService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
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
class AlgoCategoryControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AlgoCategoryService algoCategoryService;

    @Autowired
    private AlgoCategoryRepository algoCategoryRepository;

    @BeforeEach
    void setUp() {
        this.algoCategoryService = new AlgoCategoryService(algoCategoryRepository);
    }

    @Test
    @DisplayName("알고리즘 카테고리 컨트롤러 통합테스트")
    void algoCategoriesTest() throws Exception {
        // given
        // 사용자가 추가되어야 함

        // when
        Gson gson = new Gson();
        List<AlgoCategory> algoCategory = algoCategoryService.getAlgoCategory();
        String mvcResultJson = gson.toJson(algoCategory);

        // then
        mvc.perform(MockMvcRequestBuilders.get("/api/categories").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(mvcResultJson)))
                .andDo(MockMvcResultHandlers.print());
    }

}