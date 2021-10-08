package Calculator;

public enum Roman {
    I(1), IV(4), V(5), IX(9), X(10)/*,XX(20), XXX(30)*/,  XL(40), L(50)/*,LX(60),LXX(70),LXXX(80), XC(90)*/, C(100);
    public int weight;

    private Roman(int weight) {
        this.weight = weight;
    }
}

