const likeButton = document.getElementById('myPageNav__likeButton');
const purchaseButton = document.getElementById('myPageNav__purchaseButton');
const purchaseGroupButton = document.getElementById('myPageNav__purchaseGroupButton');
const myPageLike = document.querySelector('.myPageLike');
const myPagePurchase = document.querySelector('.myPagePurchase');
const myPagePurchaseGroup = document.querySelector('.myPagePurchaseGroup');

myPageLike.style.visibility = "visible";
myPagePurchase.style.visibility = "hidden";
myPagePurchaseGroup.style.visibility = "hidden";

likeButton.addEventListener("click", function() {
  myPageLike.style.visibility = "visible";
  myPagePurchase.style.visibility = "hidden";
  myPagePurchaseGroup.style.visibility = "hidden";
});

purchaseButton.addEventListener("click", function() {
  myPageLike.style.visibility = "hidden";
  myPagePurchase.style.visibility = "visible";
  myPagePurchaseGroup.style.visibility = "hidden";
});

purchaseGroupButton.addEventListener("click", function() {
  myPageLike.style.visibility = "hidden";
  myPagePurchase.style.visibility = "hidden";
  myPagePurchaseGroup.style.visibility = "visible";
});