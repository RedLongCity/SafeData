function encrypt(publicKeyUrl, arrayOfFieldForEncryption) {
    return new Promise((resolve, reject) => {
        if (arrayOfFieldForEncryption && Array.isArray(arrayOfFieldForEncryption)) {
            getPublicKey(publicKeyUrl).then(result => {
                var encrypt = new JSEncrypt();
                encrypt.setPublicKey(result);
                arrayOfFieldForEncryption.forEach((e) => {
                    var value = $(`#${e}`).val();
                    var encrypted = encrypt.encrypt(JSON.stringify(value));
                    $(`#encr_${e}`).val(encrypted);
                });
                resolve();
            }, error => {
                reject();
            });
        }
    });
}

function getPublicKey(url) {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: url,
            type: "GET",
            xhrFields: {
                withCredentials: true
            },
            success: function (result) {
                $('#publicKey').text(result["publicKey"]);
                if (result["publicKey"] != null && result["publicKey"] != "") {
                    resolve(result["publicKey"]);
                }
            },
            error: function () {
                reject('error');
            }
        });
    });
}