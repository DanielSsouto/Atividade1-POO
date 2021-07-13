package Auxiliar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Junio
 */ 
public class Consts {
    public static final int CELL_SIDE = 50;
    public static final int RES = 12; // tela tem 2*Res colunas, e Res linhas
    public static final int PERIOD = 100;   
    public static final String PATH = File.separator+"imgs"+File.separator;
    /*Em numero de frames (redesenhos). Usamos essa consntante tbm para definir
    a velocidade dos carros.*/
    public static final int TIMER_DISPARO = 15;
    public static final int TOTAL_DE_FASES = 30;
}