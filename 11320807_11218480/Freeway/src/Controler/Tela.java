package Controler;

import Modelo.*;
import Auxiliar.*;
import static Auxiliar.Consts.TOTAL_DE_FASES;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.zip.*;
/**
 *
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements KeyListener {
    private Fase faseAtual;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;    
    
    public Tela(int dif) { //dificuldade
        Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
        this.addKeyListener(this);   /*teclado*/
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(2*Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);
        
        faseAtual = new Fase(dif);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    /*Este metodo eh executado a cada Consts.PERIOD milissegundos*/    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        
        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < 2*Consts.RES; j++) {
                try {
                    //Linha para alterar o background (faixa amarela)
                    int k = Consts.RES/2 - 1;
                    if(i == k){
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "asfalto2.png");
                        g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }else{
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "asfalto.png");
                        g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }
                    //Printa as vidas da galinha na tela
                    if(i == 0){
                        if(j >= 2*Consts.RES - faseAtual.vidaGalinha() && j <= 2*Consts.RES){
                         
                         Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "galinha.png");
                         g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                         
                        }
                        //print a fase atual
                        if(j == Consts.RES){
                            int fase = (int) faseAtual.mostraFase()/10;
                            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + String.valueOf(fase) + ".png");
                            g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                        }
                        if(j == Consts.RES +1){
                            int fase = (int) faseAtual.mostraFase()/10;
                            fase = faseAtual.mostraFase() - 10*fase;
                            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + String.valueOf(fase) + ".png");
                            g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                        }
                    }                  
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        
        /* processo o jogo */
        if (!faseAtual.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(faseAtual.eElementos);
            if(this.cControle.processaTudo(faseAtual)){ // se o heroi atravessou a rua
                faseAtual.incrementaFase(); // entao ele passou de fase
            }
            if(faseAtual.mostraFase() == TOTAL_DE_FASES) // se o jogo terminou
                faseAtual.restart();
            
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };        
        
        /*Redesenha (executa o metodo paint) tudo a cada Consts.PERIOD milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.PERIOD);
    }

    public void keyPressed(KeyEvent e) {
        /*Movimento do heroi via teclado*/
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            faseAtual.hHero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            faseAtual.hHero.moveDown();
        }else if (e.getKeyCode() == KeyEvent.VK_R) {
            faseAtual = new Fase(faseAtual.mostraDificuldade());
        }
   
        /*Se o heroi for para uma posicao invalida, sorbre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(faseAtual.eElementos, faseAtual.hHero.getPosicao())) {
            faseAtual.hHero.voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (faseAtual.hHero.getPosicao().getColuna()) + ", " + (faseAtual.hHero.getPosicao().getLinha()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
