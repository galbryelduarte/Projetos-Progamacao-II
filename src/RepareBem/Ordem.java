package RepareBem;

public class Ordem {
    private String nome;
    private String telefone;
    private String peca;
    private double valorTotal;
    private Reparo[] reparos;
    private String status;

    public Ordem(String nome, String telefone, String peca) {
        this.nome = nome;
        this.telefone = telefone;
        this.peca = peca;
        this.valorTotal = 0;
        this.reparos = new Reparo[10];
        this.status = "Não iniciada";
    }

    public double calculaValorTotal() {
        double somador = 0;
        for (int i = 0; i < this.reparos.length; i++) {
            if (this.reparos[i] != null){
                somador += this.reparos[i].getPreco();
            }
        }
        return somador;
    }

    public void acrecentarReparo(Reparo reparo) {
        for (int i = 0; i < this.reparos.length; i++) {
            if (this.reparos[i] == null) {
                this.reparos[i] = reparo;
                this.valorTotal = calculaValorTotal();
                return;
            }
        }
    }

    public int getQuantidadeReparos() {
        int contador = 0;
        for (int i = 0; i < this.reparos.length; i++) {
            if (this.reparos[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return
                "cliente: " + nome + "; " +
                "roupa: " + peca + "; " +
                "reparos: " + getQuantidadeReparos() + "; " +
                "total: R$" + valorTotal;
    }
}
