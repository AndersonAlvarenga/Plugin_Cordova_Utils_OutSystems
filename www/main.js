var exec = require('cordova/exec');

//Pagamento
exports.getAppsInstalados = function (success, error) {
    exec(success, error, 'MainActivity', 'getAppsInstalados');
};
exports.pagamento = function (params, success, error) {
    exec(success, error, 'MainActivity', 'pagamento', [params]);
};

