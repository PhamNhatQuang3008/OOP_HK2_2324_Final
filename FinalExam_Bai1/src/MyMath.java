public class MyMath {
    public MyMath() {

    }
        public double sin(double x ) {
        double result = 0;
        double nterms  = 10;
        for(int i = 0;i<nterms ; i++) {
            double sign = (i % 2 == 0 ) ? 1 : -1;
            double term = Math.pow(x , 2 * i +1 ) / factorial(i * 2 + 1 );
            result += sign * term;
        }
        return result;

        }
        double cos(double x) {
            double result = 0;
            double nterms  = 10;
            for(int i = 0;i<nterms ; i++) {
                double sign = (i % 2 == 0 ) ? 1 : -1;
                double term = Math.pow(x , 2 * i ) / factorial(i * 2 );
                result += term;


            }
            return result;

        }
        public double exp(double x ) {
            double result = 0;
            double nterms  = 10;
            for(int i = 0;i<nterms ; i++) {
                double term = Math.pow(x , i ) / factorial(i);
                result += term;
            }
            return result;
            }

        public double ln(double x) {
            if (x <= -1) {
                throw new IllegalArgumentException("x must be greater than -1 for ln(1+x)");
            }
            double result = 0;
            int nTerms = 10;
            for (int n = 1; n <= nTerms; n++) {
                double sign = (n % 2 == 0) ? -1 : 1;
                double term = Math.pow(x, n) / n;
                result += sign * term;
            }
            return result;
        }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    } // Giia thừa //
}
