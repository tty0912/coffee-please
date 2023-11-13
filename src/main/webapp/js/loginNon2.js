document.addEventListener('DOMContentLoaded', function () {
   
    var NonLikeButton = document.getElementById('NonLikeButton');
    
    
    if (NonLikeButton) {
        NonLikeButton.addEventListener('click', function () {
            var popup = window.open('/coffee/views/popup.jsp', 'popup', 'width=600,height=400');


            popup.focus();
        });
    } 
});