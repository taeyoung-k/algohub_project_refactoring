package algohub.project.domain.algorithm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlgoCategory {
    private Long a_c_id;
    private String p_category;
    private String p_content;
    private Long p_number;
}
