public class Main {
    public static void main(String[] args) {
        GestionHospital hospital = new GestionHospital();

        // SIMULACIÓN DE REGISTRO
        System.out.println("SISTEMA DE GESTIÓN HOSPITALARIA v1.0");
        System.out.println("------------------------------------");
        
        // El paciente ingresa su nombre
        Paciente p1 = hospital.registrarPaciente("Jose Antonio Fonseca");
        imprimirTicket(p1);

        hospital.registrarPaciente("Miriam Arias");
        hospital.registrarPaciente("Diana Fonseca");

        // SIMULACIÓN DE LLAMADO AL CONSULTORIO
        System.out.println("\n\n>>> NOTIFICACIÓN DE PANTALLA EN SALA <<<");
        
        while (hospital.hayPacientes()) {
            Paciente actual = hospital.llamarSiguiente();
            imprimirPantallaConsultorio(actual);
            
            // Pausa breve para simular tiempo de atención
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
        }
    }

    // Diseño profesional del Ticket
    public static void imprimirTicket(Paciente p) {
        System.out.println("\n========================================");
        System.out.println("          HOSPITAL REGIONAL             ");
        System.out.println("========================================");
        System.out.println(" TURNO ASIGNADO: #" + p.getTurno());
        System.out.println(" PACIENTE: " + p.getNombre());
        System.out.println(" HORA: " + p.getHoraRegistro());
        System.out.println("----------------------------------------");
        System.out.println("   POR FAVOR ESPERE EN LA SALA B12      ");
        System.out.println("========================================\n");
    }

    // Diseño profesional de la Pantalla de Turnos
    public static void imprimirPantallaConsultorio(Paciente p) {
        System.out.println(" ______________________________________ ");
        System.out.println("|                                      |");
        System.out.println("|          CONSULTORIO MÉDICO          |");
        System.out.println("|______________________________________|");
        System.out.println("|                                      |");
        System.out.printf("|   TURNO: %-3d                         |\n", p.getTurno());
        System.out.printf("|   PACIENTE: %-25s|\n", p.getNombre());
        System.out.println("|______________________________________|");
        System.out.println("|          PASE POR FAVOR...           |");
        System.out.println("|______________________________________|");
        System.out.println("");
    }
}