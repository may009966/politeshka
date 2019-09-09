public class squareOs {
    private double a;
    squareOs(double a){
        this.a=a;
}
    public double Side() {
        return a;
    }
    public double Perimeter(){
        return a * 4;
    }
    public double Plosh(){
        return a*a;
    }
    public double Diagon(){
        return Math.sqrt(2*a*a);
    }
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Сторона: ").append(Side()).append(System.lineSeparator());
        builder.append("Периметр: ").append(Perimeter()).append(System.lineSeparator());
        builder.append("Площадь: ").append(Plosh()).append(System.lineSeparator());
        builder.append("Диагональ: ").append(Diagon()).append(System.lineSeparator());
        return builder.toString();
    }
    public class Piramida extends squareOs
    {
        public class Piramida
        {
            private double H;
           Piramida(double H) {
               this.H = H;

           }
               private double h;
               Piramida(double h){
                   this.h=h;
            super(a);
        }
        public double Volume()
        {
            return (H*a*a)/3;
        }
public double PloshBock()
            {
                return 2*a*h;
            }
            public double PloshPoln()
            {return (a+2h)*a;
            }