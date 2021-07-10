
public class NumeroComplexo implements Comparable<NumeroComplexo> {
    private int re;
    private int im;
    
    NumeroComplexo(int rr, int ii){
        re = rr;
        im = ii;
        
        return;
    }
    
    public int mostraRe(){
        return re;
    }
    
    public int mostraIm(){
        return im;
    }
    
    public double mostraModulo(){
        return Math.sqrt(this.re*this.re + this.im*this.im);
    }
    
    @Override
    public int compareTo(NumeroComplexo t) { // compara os modulos
      if(Math.sqrt(this.re*this.re + this.im*this.im) > Math.sqrt(t.re*t.re + t.im*t.im)) 
          return 1; // 
      else if(Math.sqrt(this.re*this.re + this.im*this.im) < Math.sqrt(t.re*t.re + t.im*t.im))
          return -1;
      else
          return 0;            
    }

} 
