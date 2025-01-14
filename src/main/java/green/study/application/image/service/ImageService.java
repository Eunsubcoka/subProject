package green.study.application.image.service;

import green.study.domain.course.entity.ThumbnailEntity;
import green.study.domain.course.model.Course;
import green.study.domain.course.model.Thumbnail;
import green.study.infrastructure.repository.CourseRepository;
import green.study.infrastructure.repository.ThumbnailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ThumbnailRepository thumbnailRepository;

    public void createThumbnail(MultipartFile file)throws IOException {

        String imagePath =  "C:\\DEV\\DDD_Practice\\web_study\\src\\main\\resources\\static\\images\\thumbnail"; // 프로젝트 루트 경로

        // 파일 저장 경로 설정
        File directory = new File(imagePath);
        if (!directory.exists()) {
            directory.mkdirs();  // 디렉토리가 없으면 생성
        }

        // 파일 이름 변환 (UUID 사용)
        String originName = file.getOriginalFilename();
        String convertName = UUID.randomUUID() + "_" + originName;

        // 파일을 저장 경로에 저장
        File saveFile = new File(imagePath + convertName);
        file.transferTo(saveFile);

        // DB에 이미지 정보 저장
        Thumbnail thumbnail = Thumbnail.builder()
                .thumbnailPath(imagePath + convertName)
                .originName(originName)
                .convertName(convertName)
                .uploadTime(LocalDateTime.now())
                .build();


        thumbnailRepository.save(thumbnail.toEntity());

    }
}
