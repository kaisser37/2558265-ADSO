let cuerpo = null;
window.onload = function(){
	cuerpo= document.getElementById("cuerpo");
	
	Cargarpersonas("http://localhost:8080/listapersona")

	
}

function Cargarpersonas( endpoint ){
	console.log("Iniciando consumo API: "+endpoint);

	fetch( endpoint )
	.then( respuesta => respuesta.json() )
	.then( data =>{
		console.log(data);

		cuerpo.innerHTML="";
		data.forEach(persona => {
			let fila = document.createElement("tr");

			for (const atributo in persona){
				let column = document.createElement("td");
				column.textContent=persona[atributo];
				fila.appendChild(column);
			}

			cuerpo.appendChild(fila);
			
		});
	})
};