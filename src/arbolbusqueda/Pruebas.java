package arbolbusqueda;

public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		System.out.println("-------------- Arbol binario de busqueda ------------");

		System.out.println("----------------------------------------------------");

		String [] nombres = {"Felipe Garcia", "Adriana Torres", "Alicia Blazquez Martin", "Diego Perez Gonzalez", "Mar Hernando Lopez", "Pedro Jimenez del Pozo", "Eduardo Parra Martin"};
		int [] matriculas = {1253, 2345, 5622, 8135, 8217, 8510, 8756};
		double [] calificaciones = {5.3, 7.0, 10.0, 8.0, 6.3, 3.0, 6.7};
		Alumno [] alumnos = new Alumno[nombres.length];
		for (int i = 0; i < nombres.length; i++) {
			alumnos[i] = new Alumno(nombres[i], matriculas[i], calificaciones[i]);
		}
		ArbolBinarioBusqueda Ab = new ArbolBinarioBusqueda();
		Ab.insertar(alumnos[2]);
		Ab.insertar(alumnos[5]);
		Ab.insertar(alumnos[1]);
		Ab.insertar(alumnos[0]);
		Ab.insertar(alumnos[6]);
		Ab.insertar(alumnos[3]);
		Ab.insertar(alumnos[4]);

		System.out.println("ABB alumnos (inicial). Preorden con niveles: ");
		Ab.preOrdenNivel();
		System.out.println();

		System.out.println("ABB alumnos tras agregar el rango de matrículas [1300-1310].Preorden con niveles: ");
		Ab.agregarRangoDeMatriculas(1300, 1310, new Alumno("Temporal", 1300, 0.0));
		Ab.preOrdenNivel();
		System.out.println();

		System.out.println("ABB alumnos tras eliminar el rango de matrículas [1300-6000]. Preorden con niveles:");
		Ab.eliminarRangoMatriculas(1300, 6000);
		Ab.preOrdenNivel();
		System.out.println();
	}
}
