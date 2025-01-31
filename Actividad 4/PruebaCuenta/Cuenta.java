/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaCuenta;


public class Cuenta {
  float saldo;
    int nConsignaciones = 0;
    int nRetiros = 0;
    float tAnual;
    float cMensual = 0;
public Cuenta(float saldo, float tAnual) {
    this.saldo = saldo;
    this.tAnual = tAnual;
    }
public void consignar(float cantidad) {
    saldo = saldo + cantidad; 
    nConsignaciones = nConsignaciones + 1;
    }
public void retirar(float cantidad) {
    float nuevoSaldo = saldo - cantidad;
    if (nuevoSaldo >= 0) {
    saldo -= cantidad;
    nRetiros = nRetiros + 1;
    } else {
    System.out.println("La cantidad a retirar excede el saldo actual");
    }
    }
public void calcularInterés() {
    float tMensual = tAnual / 12;
    float intMensual = saldo * tMensual;
    saldo += intMensual;
}
public void extractoMensual() {
    saldo -= cMensual;
    calcularInterés();
    }
}
