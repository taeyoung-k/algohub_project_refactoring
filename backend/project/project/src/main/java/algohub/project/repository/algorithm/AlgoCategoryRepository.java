package algohub.project.repository.algorithm;

import algohub.project.domain.algorithm.AlgoCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AlgoCategoryRepository {

    List<AlgoCategory> getAlgoCategory();
}
