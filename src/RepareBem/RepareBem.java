package RepareBem;

public class RepareBem {
    private Reparo[] reparos;
    private Ordem[] ordens;

    public RepareBem() {
        this.reparos = new Reparo[100];
        this.ordens = new Ordem[500];
    }

    private int encontraIndiceReparo(String idReparo) {
        for (int i = 0; i < this.reparos.length; i++) {
            if (this.reparos[i] != null && this.reparos[i].getIndentificador().equals(idReparo)){
                return i;
            }
        }
        return -1;
    }

    public void cadastrarReparo (String id, String descricao, double preco) {
        if (id == null) {
            throw new IllegalArgumentException("Por ser identificador único, nome não pode ser nulo.");
        }
        Reparo reparo = new Reparo(id, descricao, preco);
        for (int i = 0; i < this.reparos.length; i++) {
            if (this.reparos[i] != null && this.reparos[i].equals(reparo)) {
                throw new IllegalArgumentException("Esse reparo já foi cadastrado no sistema.");
            }
        }
        for (int i = 0; i < this.reparos.length; i++) {
            if (this.reparos[i] == null) {
                this.reparos[i] = reparo;
                return;
            }
        }
        throw new IllegalArgumentException("Não há mais espaço pra reparos.");
    }

    public void reajustarPrecoReparo(String idReparo, double percentual) {
        int indiceReparo = encontraIndiceReparo(idReparo);
        if (indiceReparo == -1) {
            throw new IllegalArgumentException("Indice inválido.");
        }
        this.reparos[indiceReparo].setPreco(percentual);
    }

    public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
        Ordem ordem = new Ordem(cliente, telefone, roupa);
        for (int i = 0; i < this.ordens.length; i++) {
            if (this.ordens[i] == null) {
                this.ordens[i] = ordem;
                return i+1;
            }
        }
        throw new IllegalArgumentException("Não há mais espaço para ordens");
    }

    public String exibirOrdemDeServico(int idOS) {
        if (idOS-1 >= this.ordens.length ) {
            throw new IllegalArgumentException("Indice inválido.");
        }
        if (this.ordens[idOS-1] == null) {
            throw new IllegalArgumentException("Indice inválido.");
        }
        return "#" + (idOS) + "; " + this.ordens[idOS-1].toString();
    }

    public void incluirReparoOrdemDeServico(int idOS, String idReparo) {
        if (idOS-1 >= this.ordens.length) {
            throw new IllegalArgumentException("Indice de Ordem inválido.");
        }
        if (this.ordens[idOS-1] == null) {
            throw new IllegalArgumentException("Indice inválido.");
        }
        int indiceReparo = encontraIndiceReparo(idReparo);
        if (indiceReparo == -1) {
            throw new IllegalArgumentException("Indice de Reparo inválido.");
        }
        if (this.ordens[idOS-1].getQuantidadeReparos() >= 10) {
            throw new IllegalArgumentException("Essa ordem não pode receber mais reparos.");
        }
        this.ordens[idOS-1].acrecentarReparo(this.reparos[indiceReparo]);
    }

    public void mudarStatusOrdemDeServico (int idOS, String status) {
        if (idOS-1 >= this.ordens.length ) {
            throw new IllegalArgumentException("Indice inválido.");
        }
        if (this.ordens[idOS-1] == null) {
            throw new IllegalArgumentException("Indice inválido.");
        }
        this.ordens[idOS-1].setStatus(status);
    }

    public double obterValorOrdemServico(int idOS) {
        if (idOS-1 >= this.ordens.length ) {
            throw new IllegalArgumentException("Indice inválido.");
        }
        if (this.ordens[idOS-1] == null) {
            throw new IllegalArgumentException("Indice inválido.");
        }
        return this.ordens[idOS-1].getValorTotal();
    }

    public String listarOrdemDeServico(String status) {
        String lista = "Ordem de Serviço - " + status + "\n\n";
        boolean verificador = false;
        for (int i = 0; i < this.ordens.length; i++) {
            if (this.ordens[i] != null && this.ordens[i].getStatus().equals(status)) {
                lista += "#" + (i+1) + "; " + this.ordens[i].toString() + "\n";
                verificador = true;
            }
        }
        if (verificador == false) {
            return lista + "Não há ordens de serviço do tipo " + status;
        }
        return lista;
    }

    public String listarOrdenDeServico() {
        String lista = "Orden de Serviço" + "\n\n";
        for (int i = 0; i < this.ordens.length; i++) {
            if (this.ordens[i] != null) {
            lista += "#" + (i+1) + "; " + this.ordens[i].toString() + "\n";
            }
        }
        return lista;
    }

}
