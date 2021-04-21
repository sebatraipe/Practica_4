package ar.unrn.tp3.modelo;

public class Participante {

	private String nombre;
	private String telefono;
	private String region;

	public Participante(String nombre, String telefono, String region) throws Exception {

		if (nombre.equals(""))
			throw new Exception("Nombre no puede ser vacio");
		if (telefono.equals(""))
			throw new Exception("Telefono no puede ser vacio");
		if (!validarTelefono(telefono))
			throw new Exception("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		if (region.equals(""))
			throw new Exception("Región no puede ser vacio");
		if (!validarRegion(region))
			throw new Exception("Region desconocida. Las conocidas  son: China, US, Europa");

		this.nombre = nombre;
		this.telefono = telefono;
		this.region = region;
	}

	private boolean validarRegion(String region) {
		return region.equals("China") || region.equals("US") || region.equals("Europa");
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public String obtenerTelefono() {
		return this.telefono;
	}

	public String obtenerRegion() {
		return this.region;
	}
}