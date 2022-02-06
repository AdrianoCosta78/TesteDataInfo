/**
 * Confirmação de exclusão da tarefa
@author Adriano Costa	
 */

function confirmar(idusu){
	let resposta = confirm("Deseja realmente excluir essa usuário?")
	if(resposta === true){
		window.location.href = "delete?idusu="+ idusu
	}
}