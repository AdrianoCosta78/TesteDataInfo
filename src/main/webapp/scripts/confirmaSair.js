/**
 * Validador do formulario Editar Tarefa
	@autor Adriano Costa
 */

function confirmaSair(idusu){
	let resposta = confirm("Deseja realmente sair?")
	if(resposta === true){
		window.location.href = "sair?idusu=" + idusu
	}
}
