package green.study.presentation.dto;

import green.study.domain.course.model.Tag;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TagReq {

    private List<String> tags;
}
