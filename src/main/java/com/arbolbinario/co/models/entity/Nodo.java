package com.arbolbinario.co.models.entity;

public class Nodo {
	
	private int dato;
	public Nodo izquierda, derecha;

	public Nodo(int dato) {
		this.dato = dato;
		this.izquierda = this.derecha = null;
	}
	
	public Nodo() {
		
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}

	public Nodo getDerecha() {
		return derecha;
	}

	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
	
	public void add(int value) {
        if (value < this.dato) {
            if (izquierda != null) {
            	izquierda.add(value);
            } else {
            	izquierda = new Nodo(value);
            }
        } else {
            if (derecha != null) {
            	derecha.add(value);
            } else {
            	derecha = new Nodo(value);
            }
        }
    }

	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", izquierda=" + izquierda + ", derecha=" + derecha + "]";
	}
	
	
	    

}
