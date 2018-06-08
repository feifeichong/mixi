var SUCCESS = "SUCCESS";
var FAIL = "FAIL";

Array.prototype.remove = function (val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};

(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        return r != null ? decodeURI(r[2]) : null;
    }
})(jQuery);

$(document).ajaxError(function (event, jqXHR, ajaxSettings, thrownError) {
    var jsonRes = jqXHR.responseJSON;
    switch (jqXHR.status) {
        case 400:
            commonModal.showModal(jsonRes.data.join(", <br>"));
            break;
        case 401:
            window.location.href = "/login.html";
            break;
        case 500:
            commonModal.showModal(jsonRes.data);
            break;
    }
});

$(document).ajaxSuccess(function (event, jqXHR, ajaxSettings, thrownError) {
    var jsonRes = jqXHR.responseJSON;
    if (!jsonRes)
        return;

    if (jsonRes.status === FAIL) {
        commonModal.showModal(jsonRes.data);
    }
});
