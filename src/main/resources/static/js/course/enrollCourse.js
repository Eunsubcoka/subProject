$(document).ready(function () {
    $('#submitButton').on('click', function () {
        const courseData = {
            title: $('#title').val(),
            description: $('#description').val(),
            price: $('#price').val(),
            thumbnail: $('#thumbnail')[0].files[0]
        };

        $.ajax({
            url: '/api/course',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(courseData),
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