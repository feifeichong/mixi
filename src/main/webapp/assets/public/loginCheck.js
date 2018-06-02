(function () {
    if (!$.cookie("MERCHANT_USER_TOKEN")) {
        window.location.href = "login.html";
    }
})();