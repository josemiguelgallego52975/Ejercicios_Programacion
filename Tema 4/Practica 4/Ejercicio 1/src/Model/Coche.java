package Model;

public class Coche {
    private String matricula ;
    private String marca;
    private int anno;
    private double precio;

    public Coche(String matricula , String marca , int anno , double precio) {
    this. matricula = matricula ;
         this.marca = marca;
         this.anno = anno;
        this.precio = precio;
    }
    public String getMatricula () { return matricula ; }
    public String getMarca () { return marca; }
    public int getAnno () { return anno; }
    public double getPrecio () { return precio; }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", anno=" + anno +
                ", precio=" + precio +
                '}';
    }
}
