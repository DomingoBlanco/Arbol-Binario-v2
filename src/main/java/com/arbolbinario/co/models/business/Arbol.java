package com.arbolbinario.co.models.business;

import org.springframework.stereotype.Service;

import com.arbolbinario.co.models.entity.Nodo;

@Service
public class Arbol {
    private Nodo raiz;

    public Arbol() {

    }

    public boolean existe(int busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(Nodo n, int busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato() == busqueda) {
            return true;
        } else if (busqueda < n.getDato()) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(Nodo padre, int dato) {
        if (dato > padre.getDato()) {
            if (padre.getDerecha() == null) {
            	
                padre.setDerecha(new Nodo(dato));
            } else {
            	
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
            	
                padre.setIzquierda(new Nodo(dato));
            } else {
            	
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    private void preorden(Nodo n) {
        if (n != null) {
            n.toString();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.toString();
            inorden(n.getDerecha());
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            n.toString();
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }
    
    public Nodo lowestCommonAncestor(Nodo root, Nodo p, Nodo q) {
    	
    	
    	if(p.getDato() == q.getDato()){
            return p;
        }
        Nodo tmp = this.raiz;
        while(true){
            if(p.getDato() < tmp.getDato() && q.getDato() < tmp.getDato()){
                tmp = tmp.izquierda;
            }else if(p.getDato() > tmp.getDato() && q.getDato() > tmp.getDato()){
                tmp = tmp.derecha;
            }else {
                return tmp;
            }
        }
    
    }
}