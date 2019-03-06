$('#formImportaDados').on('submit', e => {
e.preventDefault();
e.stopImmediatePropagation();
var json = getFormCampos(this);
return false;
});
/**
 * 
 * Retorna os dados preenchidos no formulário em formato JSON
 * 
 * @author Igor Vieira Rodrigues
 * @param {HTMLForm}
 *            prForm
 * @returns {JSON}
 */
function getFormCampos(prForm) {
    var objRetorno = {};
	var n = 0;
    while (prForm[n]) {
        var campo = prForm[n];
        var valor = null;
      if ($.isNumeric(campo.value)) {
      valor = Number(campo.value);
  } else if (campo.value !== "") {
      valor = campo.value;
  } objRetorno[campo.name] = campo.value === "" ? null : campo.value;
        n++;
        console.log(campo.name + " : " + campo.value);
    }

    return objRetorno;
}

/**
 * 
 * Preenche um formulário com o objeto JSON, e retorna o próprio formulário
 * 
 * @author Igor Vieira Rodrigues
 * @param {HTMLForm}
 *            prForm
 * @param {JSON}
 *            prJSON
 * @returns {HTMLForm}
 */
function setFormCampos(prForm, prJSON) {
    var n = 0;
    var objRetorno = {};
    while (prForm[n]) {
        var txtNome = prForm[n].name ;

        prForm[n].value = prJSON[txtNome] || '';


        n++;
    }

    return prForm;
}