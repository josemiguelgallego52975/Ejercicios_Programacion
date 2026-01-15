public class Circunferencia {
    private double radio;
    public Circunferencia(double radio) {
        this.radio = radio;
    }
    double calcularRadio(){
        return 2*Math.PI*radio;
    }
    double calcularArea(){
        return Math.PI*radio*radio;
    }
    double calcularVolume(){
        return (4*Math.PI*radio*radio*radio)/3;
    }
}
