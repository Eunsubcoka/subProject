$(document).ready(function () {
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
