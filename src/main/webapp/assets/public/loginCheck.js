(function () {
    if (!$.cookie("MERCHANT_TOKEN")) {
        window.location.href = "login.html";
    }
})();