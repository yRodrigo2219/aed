public class Atendimento{
    private int tempo = 0;
    private int tempF1, tempF2, tempF3;
    private Deque<Paciente> fila1 = new Deque<>();
    private Deque<Paciente> fila2 = new Deque<>();
    private Deque<Paciente> fila3 = new Deque<>();
    private Paciente sendoAtendido;

    private int tempoEspera1, tempoEspera2, tempoEspera3;

    public Atendimento(int tempF1, int tempF2, int tempF3) {
        this.tempF1 = tempF1;
        this.tempF2 = tempF2;
        this.tempF3 = tempF3;

        this.tempoEspera1 = 0;
        this.tempoEspera2 = 0;
        this.tempoEspera3 = 0;

        System.out.println("| id || chegada || prioridade || inicio || fim |");
    }

    public void chegarPaciente(Paciente p){
        switch(p.getPrioridade()){
            case 1:
                fila1.addLast(p);
                break;
            case 2:
                fila2.addLast(p);
                break;
            case 3:
                fila3.addLast(p);
                break;
            default:
                System.err.println("Fila inválida");
        }
    }

    public boolean isFinished(){
        switch(sendoAtendido.getPrioridade()){
            case 1:
                if(sendoAtendido.getTempInic()+tempF1 == tempo){
                    tempoEspera1 += (sendoAtendido.getTempInic() - sendoAtendido.getTempChegada());
                    tempoEspera1 /= 2;

                    sendoAtendido.setTempFim(tempo);
                    System.out.println(sendoAtendido);
                    sendoAtendido = null;
                    return true;
                }
                break;
            case 2:
                if(sendoAtendido.getTempInic()+tempF2 == tempo){
                    tempoEspera2 += (sendoAtendido.getTempInic() - sendoAtendido.getTempChegada());
                    tempoEspera2 /= 2;

                    sendoAtendido.setTempFim(tempo);
                    System.out.println(sendoAtendido);
                    sendoAtendido = null;
                    return true;
                }
                break;
            case 3:
                if(sendoAtendido.getTempInic()+tempF3 == tempo){
                    tempoEspera3 += (sendoAtendido.getTempInic() - sendoAtendido.getTempChegada());
                    tempoEspera3 /= 2;

                    sendoAtendido.setTempFim(tempo);
                    System.out.println(sendoAtendido);
                    sendoAtendido = null;
                    return true;
                }
                break;
            default:
                System.err.println("Fila inválida!");
        }

        return false;
    }

    public void start(){
        if(sendoAtendido != null){ //alguem esta sendo atendido
            if(isFinished()){
                tempo++;
                start();
                return;
            }else{
                if(sendoAtendido.getPrioridade() == 3){ // se o atendido é fila 3, ninguem bole
                    tempo++;
                    start();
                    return;
                }else{ //se não for fila 3
                    if(!fila3.isEmpty()){
                        if(fila3.peekFirst().getTempChegada() <= tempo){ // se chegar um fila 3, bole
                            if(sendoAtendido.getPrioridade() == 1){
                                fila1.addFirst(sendoAtendido);
                            }else{
                                fila2.addFirst(sendoAtendido);
                            }

                            sendoAtendido = fila3.peekFirst();
                            fila3.removeFirst();
                            sendoAtendido.setTempInic(tempo);
                        }
                    }
                    tempo++;
                    start();
                    return;
                }
            }
        }else{ // se ninguem está sendo atendido
            if(!fila3.isEmpty()){
                if(fila3.peekFirst().getTempChegada() <= tempo){
                    sendoAtendido = fila3.peekFirst();
                    fila3.removeFirst();
                    sendoAtendido.setTempInic(tempo);
                }
            }else if(!fila2.isEmpty()){
                if(fila2.peekFirst().getTempChegada() <= tempo){
                    sendoAtendido = fila2.peekFirst();
                    fila2.removeFirst();
                    sendoAtendido.setTempInic(tempo);
                }
            }else if(!fila1.isEmpty()){
                if(fila1.peekFirst().getTempChegada() <= tempo){
                    sendoAtendido = fila1.peekFirst();
                    fila1.removeFirst();
                    sendoAtendido.setTempInic(tempo);
                }
            }else{
                System.out.println("Fim da execucao!\n");

                System.out.println("Tempo medio fila 1: " + tempoEspera1);
                System.out.println("Tempo medio fila 2: " + tempoEspera2);
                System.out.println("Tempo medio fila 3: " + tempoEspera3);
                return;
            }
            tempo++;
            start();
            return;
        }
    }

}