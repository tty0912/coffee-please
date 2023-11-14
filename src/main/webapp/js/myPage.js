const myPageNavlikeButton = document.getElementById('myPageNav__likeButton');
const purchaseButton = document.getElementById('myPageNav__purchaseButton');
const purchaseGroupButton = document.getElementById('myPageNav__purchaseGroupButton');
const myPageLike = document.querySelector('#myPageLike');
const myPagePurchase = document.querySelector('#myPagePurchase');
const myPagePurchaseGroup = document.querySelector('#myPagePurchaseGroup');

likeButton.addEventListener("click", function() {
    myPageNavlikeButton.style.display = "block";
    myPagePurchase.style.display = "none";
    myPagePurchaseGroup.style.display = "none";
});
purchaseButton.addEventListener("click", function() {
    myPageNavlikeButton.style.display = "none";
    myPagePurchase.style.display = "block";
    myPagePurchaseGroup.style.display = "none";
});
purchaseGroupButton.addEventListener("click", function() {
    myPageNavlikeButton.style.display = "none";
    myPagePurchase.style.display = "none";
    myPagePurchaseGroup.style.display = "block";
});