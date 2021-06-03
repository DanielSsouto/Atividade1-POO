/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class ContaCorrente {

    private String usuario;
    private float saldo;
    private float creditoLimite;
    private float creditoUsado;
    
    
    ContaCorrente(String _usuario, float _saldo, float _credito){
        saldo = _saldo;
        usuario = _usuario;
        creditoLimite = _credito;
        creditoUsado = (float) 0.0;
        
    }
    
    
    public void Depositar(float _valor) throws ValorForaDosLimites{
      if(_valor<0) throw new ValorForaDosLimites("Deposito negativo nao pode ser realizado");
        else {
                    saldo = saldo - _valor;
                    System.out.print("Deposito Realizado! Saldo atual de conta corrente: "+ String.valueOf(saldo));
        }
    }
    
    public void Sacar(float _valor) throws ValorForaDosLimites{
        if(saldo+creditoLimite<_valor) throw new ValorForaDosLimites("Saque maior do que disponível na conta corrente");
        else if(_valor<0) throw new ValorForaDosLimites("Saque negativo nao pode ser realizado");
        else {

                    saldo = saldo - _valor;
                    System.out.print("Saque Realizado! Saldo atual de conta corrente: "+ String.valueOf(saldo));
        }
    }
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the creditoLimite
     */
    public float getCreditoLimite() {
        return creditoLimite;
    }

    /**
     * @param creditoLimite the creditoLimite to set
     */
    public void setCreditoLimite(float creditoLimite) {
        this.creditoLimite = creditoLimite;
    }

    /**
     * @return the creditoUsado
     */
    public float getCreditoUsado() {
        return creditoUsado;
    }

    /**
     * @param creditoUsado the creditoUsado to set
     */
    public void setCreditoUsado(float creditoUsado) {
        this.creditoUsado = creditoUsado;
    }
    
    
}
