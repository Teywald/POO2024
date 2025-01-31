/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarreraCiclistica;


public class Velocista extends Ciclista{
    private  double potenciaPromedio;
    private double velocidadPromedio;

    public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedio) {
        super(identificador, nombre);
        potenciaPromedio= potenciaPromedio;
        this.velocidadPromedio = velocidadPromedio;
    }
    protected double getPotenciaPromedio() {
        return potenciaPromedio;
    }
    protected void setPotenciaPromedio(double potenciaPromedio) {
        this.potenciaPromedio = potenciaPromedio;
    }
    protected double getvelocidadPromedio() {
        return velocidadPromedio;
    }
    protected void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    @Override
    protected void imprimir() {
        super.imprimir();
        System.out.println("Potencia promedio = " + potenciaPromedio);
        System.out.println("Velocidad promedio = " + velocidadPromedio);
    }

    @Override
    protected String imprimirTipo() {
        return "es un velocista";
    }
}
