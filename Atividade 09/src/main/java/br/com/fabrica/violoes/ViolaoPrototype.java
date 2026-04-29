package br.com.fabrica.violoes;

public interface ViolaoPrototype {
    ViolaoPrototype cloneSuperficial();

    ViolaoPrototype cloneProfundo();
}
