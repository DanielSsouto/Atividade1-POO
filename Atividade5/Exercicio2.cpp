#include <cmath>
#include <iostream>
using namespace std;

class complexo{
    private:
        float re;
        float img;
    public:
        complexo(float real, float imaginario){
            re = real;
            img = imaginario;
        };

        complexo soma(const complexo &z){
            return complexo(this->re +  z.re, this->img +  z.img);
        };

        complexo subtrai(const complexo &z){
            return complexo(this->re - z.re, this->img - z.img);
        };

        complexo multiplica(const complexo &z){
            return complexo(this->re*z.re - this->img*z.img, this->re*z.img + this->img*z.re);
        };
      
        float modulo(){
            return sqrt(pow(re, 2)+pow(img, 2));
        };

        void mostraNumero(){
            if (img < 0)
                cout << re << " - i" << img << "\n";
            else
                cout << re << " + i" << img << "\n";
        }
};

int main(){
    complexo z(1, 1);
    complexo w(1, -1);
    
    z.soma(w).mostraNumero();
    z.subtrai(w).mostraNumero();
    z.multiplica(w).mostraNumero();
    cout << "Modulo:" << z.modulo();


    return 0;
}

