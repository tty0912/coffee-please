document.addEventListener('DOMContentLoaded', function () {
    var sellerLikeButton = document.getElementById('sellerLikeButton');
    
    if (sellerLikeButton) {
        sellerLikeButton.addEventListener('click', function () {
            var popup = window.open('/coffee/views/sellerPopup.jsp', 'popup', 'width=600,height=400');


            popup.focus();
        });
    } 
});