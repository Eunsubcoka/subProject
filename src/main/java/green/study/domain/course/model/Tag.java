package green.study.domain.course.model;

import green.study.domain.course.entity.TagEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    private Long tagNo;

    private Long courseNo;

    private String name;


    public static TagEntity toTagEntity(Long courseNo, String name){
        return TagEntity.builder()
                .name(name)
                .courseNo(courseNo)
                .build();
    }

    public static Tag from(TagEntity tagEntity) {
        return Tag.builder()
                .tagNo(tagEntity.getTagNo())
                .name(tagEntity.getName())
                .courseNo(tagEntity.getCourseNo())
                .build();
    }

}
