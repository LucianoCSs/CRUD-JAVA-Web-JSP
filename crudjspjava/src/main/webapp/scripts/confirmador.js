/**
 * 
 */

function confirmar(id){
	let resposta = confirm("Confirma a exclusão desde contato?")
	if(resposta === true){
		window.location.href = "delete?id=" + id
	}
}