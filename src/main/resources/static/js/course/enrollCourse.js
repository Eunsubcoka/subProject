$(document).ready(function () {
    let videoData = []; // ✅ 영상 제목을 저장할 배열

    $('#submitButton').on('click', function () {
        const courseData = {
            title: $('#title').val(),
            description: $('#description').val(),
            price: $('#price').val()
        };

        const categoryData = {
            category: $('#category').val(),
            subcategory: $('#subcategory').val()
        };

        // ✅ 태그 데이터를 `{ "tags": [...] }` 형태의 JSON 객체로 변환
        const tagData = {
            tags: []
        };
        $('#tagContainer .badge').each(function () {
            tagData.tags.push($(this).text().trim());
        });

        const formData = new FormData();
        formData.append('courseData', new Blob([JSON.stringify(courseData)], { type: "application/json" }));
        formData.append('categoryData', new Blob([JSON.stringify(categoryData)], { type: "application/json" }));
        formData.append('tagData', new Blob([JSON.stringify(tagData)], { type: "application/json" }));
        formData.append('thumbnail', $('#thumbnail')[0].files[0]);
        formData.append('videoData', new Blob([JSON.stringify(videoData)], { type: "application/json" }))
        $.ajax({
            url: '/api/course',
            method: 'POST',
            data: formData,
            contentType: false, // 콘텐츠 타입 자동 설정 방지
            processData: false, // jQuery의 자동 변환 방지
            success: function (response) {
                alert('강의가 성공적으로 등록되었습니다!');
                console.log(response);
            },
            error: function (xhr, status, error) {
                alert('강의 등록 중 오류가 발생했습니다.');
                console.error(error);
            }
        });
    });
});

// ------------------- 카테고리 및 태그 추가 기능 -------------------
document.addEventListener("DOMContentLoaded", function () {
    const categories = {
        "프로그래밍": ["Java", "Python", "JavaScript", "C++", "Go"],
        "데이터 사이언스": ["데이터 분석", "머신러닝", "딥러닝", "SQL"],
        "비즈니스": ["마케팅", "재무/회계", "창업", "프로젝트 관리"],
        "디자인": ["UX/UI", "그래픽 디자인", "3D 모델링"],
    };

    const categorySelect = document.getElementById("category");
    const subcategorySelect = document.getElementById("subcategory");

    // 대분류 변경 시 소분류 업데이트
    categorySelect.addEventListener("change", function () {
        const selectedCategory = categorySelect.value;
        subcategorySelect.innerHTML = ""; // 기존 옵션 초기화

        if (categories[selectedCategory]) {
            categories[selectedCategory].forEach(sub => {
                const option = document.createElement("option");
                option.value = sub;
                option.textContent = sub;
                subcategorySelect.appendChild(option);
            });
        }
    });


    // 영상 제목 추가 함수
    function addVideoTitle() {
        const videoTitle = $('#videoTitleInput').val().trim();

        if (videoTitle !== "") {
            // 배열에 추가
            videoData.push(videoTitle);

            // UI 업데이트
            updateVideoList();

            // 입력 필드 초기화
            $('#videoTitleInput').val("");
        } else {
            alert("영상 제목을 입력하세요!");
        }
    }

    // 리스트 UI 업데이트 함수
    function updateVideoList() {
        $('#videoTitleList').empty(); // 기존 목록 초기화

        videoData.forEach((title, index) => {
            const listItem = $('<li class="list-group-item d-flex justify-content-between align-items-center"></li>')
                .text(title);

            // 삭제 버튼 추가
            const deleteButton = $('<button class="btn btn-danger btn-sm">삭제</button>');
            deleteButton.on('click', function () {
                removeVideoTitle(index);
            });

            listItem.append(deleteButton);
            $('#videoTitleList').append(listItem);
        });
    }

    // 영상 제목 삭제 함수
    function removeVideoTitle(index) {
        videoData.splice(index, 1); // 배열에서 제거
        updateVideoList(); // UI 갱신
    }

    // 버튼 클릭 시 영상 제목 추가
    $('#addVideoTitleButton').on('click', addVideoTitle);

    // Enter 키 입력 시 영상 제목 추가
    $('#videoTitleInput').on('keypress', function (event) {
        if (event.key === "Enter") {
            event.preventDefault();
            addVideoTitle();
        }
    });

    // 태그 입력 기능
    const tagInput = document.getElementById("tagInput");
    const tagContainer = document.getElementById("tagContainer");

    tagInput.addEventListener("keypress", function (event) {
        if (event.key === "Enter") {
            event.preventDefault();
            const tagValue = tagInput.value.trim();

            if (tagValue !== "") {
                const tag = document.createElement("span");
                tag.className = "badge bg-secondary m-1";
                tag.textContent = tagValue;

                // 태그 삭제 기능
                tag.addEventListener("click", function () {
                    tagContainer.removeChild(tag);
                });

                tagContainer.appendChild(tag);
                tagInput.value = ""; // 입력 필드 초기화
            }
        }
    });
});
