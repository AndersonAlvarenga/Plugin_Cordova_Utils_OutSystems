var exec = require('cordova/exec');

//Pagamento
exports.getVersion = function (success, error) {
    exec(success, error, 'MainActivity', 'getVersion');
};
exports.pagamento = function (params, success, error) {
    exec(success, error, 'MainActivity', 'pagamento', [params]);
};
exports.GetStringImpressao = function (success, error) {
    exec(success, error, 'MainActivity', 'GetStringImpressao');
};
exports.limpaTransacao = function (success, error) {
    exec(success, error, 'MainActivity', 'limpaTransacao');
};
exports.cancelarTransacao = function (success, error) {
    exec(success, error, 'MainActivity', 'cancelarTransacao');
};
exports.GetDadosTransacao = function (success, error) {
    exec(success, error, 'MainActivity', 'GetDadosTransacao');
};

