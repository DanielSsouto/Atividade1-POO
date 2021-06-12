package Controler;

import Modelo.*;
import Auxiliar.*;
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
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {
    /*
    private Galinha hHero;
    private Carro CarroAzul, CarroAmarelo, CarroVerdeClaro, CarroLaranja;
    private ArrayList<Elemento> eElementos;*/
    private Fase faseAtual;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;
   
    public Tela(int dif) {
        Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
 
        this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(2*Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        
        faseAtual = new Fase(dif);
        /*
        /*Este array vai guardar os elementos graficos
        eElementos = new ArrayList<Elemento>(100);
        
        /*Cria eElementos adiciona elementos*/
        /*O protagonista (heroi) necessariamente precisa estar na posicao 0 do array
        hHero = new Galinha("galinha.png", 14, 1); /* https://www.online-image-editor.com/ 
        //hHero.setPosicao(14, 1);
        this.addElemento(hHero);
        
        CarroAzul = new Carro("carro_azul.png", true, "azul", 10, 185);
        //CarroAzul.setPosicao(10, 185);
        this.addElemento(CarroAzul);
        
        CarroAmarelo = new Carro("carro_amarelo.png", true, "amarelo", 9, 185);
        //CarroAmarelo.setPosicao(9, 185);
        this.addElemento(CarroAmarelo);
        
        CarroLaranja = new Carro("carro_laranja.png", true, "laranja", 1, 185);
        //CarroLaranja.setPosicao(1, 185);
        this.addElemento(CarroLaranja);*/
        
    }

/*--------------------------------------------------*/
    /*public void addElemento(Elemento umElemento) {
        eElementos.add(umElemento);
    }

    public void removeElemento(Elemento umElemento) {
        eElementos.remove(umElemento);
    }*/

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
                    //Linha para alterar o background
                    int k = Consts.RES/2 - 1;
                    if(i == k){
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "asfalto2.png");
                        g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }else{
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "asfalto.png");
                        g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        
        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!faseAtual.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(faseAtual.eElementos);
            this.cControle.processaTudo(faseAtual.eElementos);
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
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            faseAtual.hHero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            faseAtual.hHero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            faseAtual = new Fase(faseAtual.mostraDificuldade());
            /*
            hHero = new Galinha("galinha.png", 14, 1); /* https://www.online-image-editor.com/ 
            //hHero.setPosicao(14, 1);
            this.addElemento(hHero);

            CarroAzul = new Carro("carro_azul.png", true, "azul", 10, 185);
            //CarroAzul.setPosicao(10, 185);
            this.addElemento(CarroAzul);

            CarroAmarelo = new Carro("carro_amarelo.png", true, "amarelo", 9, 185);
            //CarroAmarelo.setPosicao(9, 185);
            this.addElemento(CarroAmarelo);

            CarroLaranja = new Carro("carro_laranja.png", true, "laranja", 1, 185);
            //CarroLaranja.setPosicao(1, 185);
            this.addElemento(CarroLaranja);*/
        }
        
   
        /*Se o heroi for para uma posicao invalida, sorbre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(faseAtual.eElementos, faseAtual.hHero.getPosicao())) {
            faseAtual.hHero.voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (faseAtual.hHero.getPosicao().getColuna()) + ", " + (faseAtual.hHero.getPosicao().getLinha()));
    }

    public void mousePressed(MouseEvent e) {
         //Movimento via mouse
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         faseAtual.hHero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);

        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(faseAtual.eElementos,faseAtual.hHero.getPosicao())) {
            faseAtual.hHero.voltaAUltimaPosicao();
        }         
         
        repaint();
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

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
