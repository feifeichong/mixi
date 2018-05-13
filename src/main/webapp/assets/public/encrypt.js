function base64Encode(toEncryptStr) {
    var temp = CryptoJS.enc.Utf8.parse(toEncryptStr);
    var base64Str = CryptoJS.enc.Base64.stringify(temp);
    return base64Str;
}

function base64Decode(toDecryptStr) {
    var temp = CryptoJS.enc.Base64.parse(toDecryptStr);
    return temp.toString(CryptoJS.enc.Utf8);
}

function calcMD5(toEncryptStr) {
    if (!toEncryptStr) {
        return null;
    }
    return CryptoJS.MD5(toEncryptStr).toString();
}

function calcMD5_Bin16(toEncryptStr) {
    var str = calcMD5(toEncryptStr);
    if (!str) {
        return null;
    }
    return str.substring(0, 16);
}

function isAesInputValid(str, keyStr) {
    return str && keyStr && keyStr.length === 16;
}

function aesEncrypt(toEncryptStr, keyStr) {
    if (!isAesInputValid(toEncryptStr, keyStr))
        return null;

    var key = CryptoJS.enc.Utf8.parse(keyStr);
    var iv = CryptoJS.enc.Utf8.parse(keyStr);

    var encrypted = CryptoJS.AES.encrypt(toEncryptStr, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.ZeroPadding
    });
    return encrypted.toString();
}

function aesDecrypt(toDecryptStr, keyStr) {
    if (!isAesInputValid(toDecryptStr, keyStr))
        return null;

    var key = CryptoJS.enc.Utf8.parse(keyStr);
    var iv = CryptoJS.enc.Utf8.parse(keyStr);

    var decrypted = CryptoJS.AES.decrypt(toDecryptStr, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.ZeroPadding
    });
    return decrypted.toString(CryptoJS.enc.Utf8);
}

function rsaEncrypt(toEncryptStr, rsaKey) {
    var exponent = rsaKey.exponent;
    var modulus = rsaKey.modulus;
    setMaxDigits(129);
    var key = new RSAKeyPair(exponent, "", modulus);
    return encryptedString(key, toEncryptStr);
}

function rsaDecrypt(toDecryptStr, rsaKey) {
    var exponent = rsaKey.exponent;
    var modulus = rsaKey.modulus;
    setMaxDigits(129);
    var key = new RSAKeyPair("", exponent, modulus);
    return decryptedString(key, toDecryptStr);
}