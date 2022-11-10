var exec = require('cordova/exec');

//Pagamento
exports.getVersion = function (success, error) {
    exec(success, error, 'MainActivity', 'getVersion');
};
exports.getAppsInstalados = function (success, error) {
    exec(success, error, 'MainActivity', 'getAppsInstalados');
};
exports.deleteApp = function (params, success, error) {
    exec(success, error, 'MainActivity', 'deleteApp', [params]);
};
exports.abrirApp = function (params, success, error) {
    exec(success, error, 'MainActivity', 'abrirApp', [params]);
};

