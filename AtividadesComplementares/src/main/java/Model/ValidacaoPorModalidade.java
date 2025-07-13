package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidacaoPorModalidade {
    private RequerimentoValidado requerimentoValidado;
    private Map<Modalidade, Boolean> ValidacaoPorModalidade;
    private List<String> violations;

    public ValidacaoPorModalidade(RequerimentoValidado requerimentoValidado) {
        this.requerimentoValidado = requerimentoValidado;
        this.ValidacaoPorModalidade = new HashMap<>();
        this.violations = new ArrayList<>();
    }

    public List<String> violations() {
        return violations;
    }

    public void validar(){
        for (Modalidade modalidade: this.modalidadesExistentes()) {

            int horasTotais = this.requerimentoValidado.totalDeHorasValidadas(new FiltroNulo());
            int horasPorModalidade = this.requerimentoValidado.totalDeHorasValidadas(new FiltroPorModalidade(modalidade));
            double pctMax = modalidade.porcentagemMaxima();
            double horasPermitidas = horasTotais * pctMax / 100;
            if (horasPorModalidade > horasPermitidas) {
                String msg = "Modalidade " + modalidade.nome() +
                        "excede limite: declarou " + horasPorModalidade +
                        ", mas máximo permitido é" + horasPermitidas +
                        " ("+ pctMax + "do total).";
                this.violations.add(msg);
                this.ValidacaoPorModalidade.put(modalidade,false);
            }
            else{
                this.ValidacaoPorModalidade.put(modalidade,true);
            }
        }
    }

    public Boolean modalidadeEhValida(Modalidade modalidade){
        return this.ValidacaoPorModalidade.get(modalidade);
    }

    public ArrayList<Modalidade> modalidadesExistentes(){
        ArrayList<Modalidade> modalidades = new ArrayList<>();
        for (AtividadeValidada atividadeValidada: this.requerimentoValidado.getAtividadesValidadas()) {
            if(!modalidades.contains(atividadeValidada.modalidade())){
                modalidades.add(atividadeValidada.modalidade());
            }
        }
        return modalidades;
    }
}
