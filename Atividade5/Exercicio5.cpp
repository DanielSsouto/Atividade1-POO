#include <iostream> // cin, cout
#include <vector> // vector
#include <cstdio> // rand()
#include <cmath> // pow(), sqrt()

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

        complexo operator+(const complexo &z){
            return complexo(this->re +  z.re, this->img +  z.img);
        };

        complexo operator-(const complexo &z){
            return complexo(this->re - z.re, this->img - z.img);
        };

        complexo operator*(const complexo &z){
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

int main (){
    vector<complexo> Complexos; // os numeros que iremos gerar
    complexo soma(0, 0); // a soma total dos elementos de Complexos
    vector<complexo>::iterator z;
    int n;

    cout << "Digite a quantidades de numeros que devemos gerar: ";
    cin >> n;

    //preenche o veotr, usando  algarismos de 0 a 99 para facilitar a vizualização
    for(int i = 0; i<= n-1; i++){
        Complexos.push_back(complexo(rand() % 100, rand() % 100)); // insere um complexo aleatorio no vector
	Complexos[i].mostraNumero();
    }
    
    // faz a soma
    for(z = Complexos.begin(); z != Complexos.end(); z++){
        soma = soma + *z;
    }

    cout << "Soma resultante: ";
    soma.mostraNumero();

    Complexos.clear();

    return 0;
}
