package sistemaA;

public class Avaliacao {
    private double notaP1;
    private double notaP2;
    private double notaP3;
    private int presenca;

    class avaliacao{
        this.notaP1=0;
        this.notap2=0;
        this.notaP3=0;
        this.presenca=0;
    }

    public double getNotaP1(){
        return notaP1;
    }

    public double getNotaP2(){
        return notaP2;
    }

    public double getNotaP3(){
        return notaP3;
    }

    public int getPresencas(){
        return presenca;
    }

    public double calcularMedia(double notaP1,double notaP2,double notaP3){
            return (notaP1+notaP2+notaP3)/2.0;
    }

    public boolean verificarFrequencia(int presenca){
            return presenca>=75.0;
    }

    public String verificarAprovacao() {
        double media = calcularMedia(media, media, media);
        boolean frequenciaOK = verificarFrequencia(presenca);

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