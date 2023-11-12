$(document).ready(function() {
    $("#beanImgFile").on('change', function() {
        var fileName = $(this).val().split('\\').pop();
        $(".beanImg-name").val(fileName || "대표이미지를 넣어주세요.");
    });
});
