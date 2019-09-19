public class Paciente{
    private int id, tempChegada, prioridade, tempInic, tempFim;

    public Paciente(int id, int t, int prioridade) {
        this.id = id;
        this.tempChegada = t;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempChegada() {
        return tempChegada;
    }

    public void setTempChegada(int tempChegada) {
        this.tempChegada = tempChegada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getTempInic() {
        return tempInic;
    }

    public void setTempInic(int tempInic) {
        this.tempInic = tempInic;
    }

    public int getTempFim() {
        return tempFim;
    }

    public void setTempFim(int tempFim) {
        this.tempFim = tempFim;
    }

    @Override
    public String toString(){
        return String.format("|%3d |", id) + String.format("|%5d    |", tempChegada) + String.format("|%7d     |", prioridade) + String.format("|%5d   |", tempInic) + String.format("|%4d |", tempFim);
    }

}