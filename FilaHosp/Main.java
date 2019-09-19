public class Main{
    public static void main(String[] args) {
        Atendimento a = new Atendimento(2, 4, 8);

        /*  Os pacientes devem ser adicionado de antemao,
        a ordem é: id, tempo de chegada, prioridade 
            Os pacientes devem estar em ordem de chegada,
        um paciente que chegou no tempo 4 não deve ser 
        declarado antes de um paciente que chegou no 
        tempo 3, por exemplo! */
        a.chegarPaciente(new Paciente(1, 1, 2));
        a.chegarPaciente(new Paciente(2, 1, 1));
        a.chegarPaciente(new Paciente(3, 2, 3));
        a.chegarPaciente(new Paciente(4, 2, 2));
        a.chegarPaciente(new Paciente(5, 2, 1));
        a.chegarPaciente(new Paciente(6, 4, 2));
        
        a.start();
    }
}