package algohub.project.repository.algorithm;

import algohub.project.controller.algorithm.dto.AlgoListDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AlgorithmRepository {

    List<AlgoListDto> getAlgoList(String categoryId);
}
