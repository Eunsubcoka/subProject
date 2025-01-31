package green.study.application.image.service;

import green.study.domain.course.model.Thumbnail;
import green.study.infrastructure.repository.ThumbnailRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService { // 사이트 내 이미지 서비스 
    
    private final ThumbnailRepository thumbnailRepository;

    // 파일 변환 및 저장
    @Transactional
    public void createThumbnail(MultipartFile file,Long courseNo)throws IOException {

        String imagePath =  "C:\\DEV\\DDD_Practice\\web_study\\src\\main\\resources\\static\\images\\thumbnail\\"; // 프로젝트 루트 경로

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
                .courseNo(courseNo)
                .build();

        thumbnailRepository.save(thumbnail.toEntity());

    }
}
