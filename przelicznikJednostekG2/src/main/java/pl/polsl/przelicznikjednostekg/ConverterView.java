/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.przelicznikjednostekg;

/**
 *
 * @author Paweł Gołąbek
 */
public class ConverterView {
    private int slot;
    private String name;
    private float A;
    private float B;

    public ConverterView(int slot, String name, float A, float B) {
        this.slot = slot;
        this.name = name;
        this.A = A;
        this.B = B;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getA() {
        return A;
    }

    public void setA(float A) {
        this.A = A;
    }

    public float getB() {
        return B;
    }

    public void setB(float B) {
        this.B = B;
    }
}
