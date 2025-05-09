package sistemaA;

public class Avaliacao {
    private double notaP1;
    private double notaP2;
    private double notaP3;
    private int presenca;

    public Avaliacao(double notaP1, double notaP2, double notaP3, int presenca) {
        this.notaP1 = notaP1;
        this.notaP2 = notaP2;
        this.notaP3 = notaP3;
        this.presenca = presenca;
    }

    public double getNotaP1() {
        return notaP1;
    }

    public double getNotaP2() {
        return notaP2;
    }

    public double getNotaP3() {
        return notaP3;
    }

    public int getPresenca() {
        return presenca;
    }

    public double calcularMedia() {
        return (notaP1 + notaP2 + notaP3) / 3.0;
    }

    public boolean verificarFrequencia() {
        return presenca >= 75;
    }

    public String verificarAprovacao() {
        double media = calcularMedia();
        boolean frequenciaOK = verificarFrequencia();

        if (frequenciaOK && media >= 6.0) {
            return "Aprovado";
        } else if (!frequenciaOK && media >= 6.0) {
            return "Reprovado por falta";
        } else if (frequenciaOK && media < 6.0) {
            return "Reprovado por nota";
        } else {
            return "Reprovado por nota e falta";
        }
    }
}
