package Gestion_Hospitalaria;

public class PacienteGrave extends Paciente{

	private TipoGravedad gravedad;

    public PacienteGrave(String nombre, TipoGravedad gravedad){
        super(nombre);
        this.gravedad = gravedad;
    }

    public String toString(){
    	return " ID: " + getId() + "  " + getNombre() + "  Gravedad: " + gravedad;
    }
    
    public TipoGravedad getGravedad() {
    	return gravedad;    	
    }

}
