package green.study.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class VideoReq {
    private List<String> videos;
}
