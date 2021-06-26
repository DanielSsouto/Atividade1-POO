
public class Cliente {
    private int saldo;

    Cliente(){
        saldo = 0;
    }

    int mostraSaldo(){
        return saldo;
    }

    void deposita(int iValor){
        int novo_saldo = saldo + iValor;
        //System.out.println("Seu novo saldo eh "+novo_saldo);
        saldo = novo_saldo;
    }

    int saca_10(){
        int novo_saldo = saldo - 10;
        //System.out.println("Seu novo saldo eh "+novo_saldo);
        saldo = novo_saldo;

        return 10;
    }
}

