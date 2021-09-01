package com.arus.usuario.clientes;

import java.text.SimpleDateFormat;
import com.arus.usuarios.model.bo.UsuarioBO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class UsuarioApi {
	private static final String REST_URI = "http://localhost:8084/solicitudes/api/v1/usuarios";

	public void crearUsuario(UsuarioBO usuario) throws Exception {

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String input = "{\"tipoDeDocumento\":\"" + usuario.getTipoDeDocumento() + "\"," + "\"documento\":\""
				+ usuario.getDocumento() + "\"," + "\"primerNombre\":\"" + usuario.getPrimerNombre() + "\","
				+ "\"segundoNombre\":\"" + usuario.getSegundoNombre() + "\"," + "\"primerApellido\":\""
				+ usuario.getPrimerApellido() + "\"," + "\"segundoApellido\":\"" + usuario.getSegundoApellido() + "\","
				+ "\"administradoraSalud\":\"" + usuario.getAdministradoraSalud() + "\","
				+ "\"fechaAfiliacionASalud\":\"" + formatoFecha.format(usuario.getFechaAfiliacionASalud()) + "\","
				+ "\"administradoraDePension\":\"" + usuario.getAdministradoraDePension() + "\","
				+ "\"fechaAfiliacionAPension\":\"" + formatoFecha.format(usuario.getFechaAfiliacionAPension()) + "\"}";

		Client client = Client.create();
		ClientResponse respuesta = null;
		try {
			respuesta = client.resource(REST_URI).type("application/json").post(ClientResponse.class, input);
		} catch (Exception e) {
			throw new Exception("Ocurrió un error al conectarse al servicio web: " + e.getMessage());
		}

		
		if (respuesta.getStatus() != 200) {
			throw new Exception("Ocurrió un error al momento de crear el usuario en el servicio web");
		}
	}

}
