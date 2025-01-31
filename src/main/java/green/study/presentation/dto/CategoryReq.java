package green.study.presentation.dto;

import green.study.domain.course.model.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryReq {
    private String category;    // 대분류
    private String subcategory; // 소분류

    public Category toCategory(){
        return Category.builder()
                .mainCategoryName(category)
                .subCategoryName(subcategory)
                .build();

    }

}
