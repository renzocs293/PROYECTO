
function btnEliminar(e, id) {
	e.preventDefault();
	Swal.fire({
		title: '¿Estás seguro?',
		text: "El bus se eliminará definitivamente",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Sí, eliminar',
		cancelButtonText: 'Cancelar'

	}).then((result) => {
		if (result.isConfirmed) {

			window.location.href = `/eliminar/${id}`;

			Swal.fire(
				'Eliminado!',
				'El bus fue eliminado',
				'success'
			)
		}
	})
}


