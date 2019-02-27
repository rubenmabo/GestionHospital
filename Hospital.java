package Gestion_Hospitalaria;

import java.util.Arrays;

public class Hospital {
	
	private Paciente tpacientes[];
    private int contadorpacientes;

    public Hospital(int numpacientes){
        tpacientes = new Paciente[numpacientes];
        contadorpacientes = 0;
    }

    //Ingreso de un paciente al hospital
    public boolean ingreso(Paciente p){
    	boolean resultado = false;
    	tpacientes[contadorpacientes]=p;
    	contadorpacientes++;
    	return resultado;
    }
    
    //Alta del paciente - se borra de la tabla
    public boolean alta (int id_paciente){
    	boolean resultado = false;
    	int posicion=-1;
    	for (int i=0; i < contadorpacientes; i++) {
    		if(tpacientes[i].getId()==id_paciente) {
    			posicion = i;
    			resultado=true;
    		}
    		
    	}
    	
    	if(posicion >=0) {
    		for(int i = posicion; i<contadorpacientes; i++) {
    			tpacientes[i] = tpacientes[i+1];
    		}
    		resultado = true;
    	}else {
    		resultado = false;
    	}
    	contadorpacientes--;
    	return resultado;
    }    
    
    //Devuelve el paciente con el identidador indicado o null si no existe
    public Paciente buscar(int id){
    	Paciente p = null;
    	for(int i=0; i<contadorpacientes; i++) {
    		if(tpacientes[i].getId()==id) { 
    			p = tpacientes[i];
    		}
    	}
    	return p;
    }
    
    // Imprime por consola la lista ORDENADO por NOMBRE de pacientes ***

    public void listapacientes (){
    	System.out.println(" ######## LISTA DE PACIENTES ######## ");
    	Arrays.sort(tpacientes, 0, contadorpacientes);
    	for(int i=0; i < contadorpacientes; i++) {
    		System.out.println(tpacientes[i].toString());
    	}
    }    
       
    // Devuelve el mas grave o el caso de paciente con la misma gravedad el
    // que su identificador sea mas bajo.
    public Paciente pacienteMasUrgente(){
    	PacienteGrave muygrave = null;
  
    	for (int i=0; i < contadorpacientes; i++) {
    		Paciente aux = tpacientes[i];
    		if(tpacientes[i] instanceof PacienteGrave == true) {
    			PacienteGrave auxgrave = (PacienteGrave) aux;
    			if (auxgrave.getGravedad().ordinal() > muygrave.getGravedad().ordinal()) {
    				muygrave = auxgrave;
    			}else if(auxgrave.getGravedad().ordinal() == muygrave.getGravedad().ordinal()){
    				if (auxgrave.getId() > muygrave.getId()) {
    					muygrave = auxgrave;
    				}
    			}
    		}
    	}
    	
    	return muygrave;
    }
    
}