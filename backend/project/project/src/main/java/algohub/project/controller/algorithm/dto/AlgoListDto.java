package algohub.project.controller.algorithm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlgoListDto {
    private String p_category;
    private int p_number;
    private int a_id;
    private String p_title;
    private String m_name;
    private String p_link;
    private String language;
}
