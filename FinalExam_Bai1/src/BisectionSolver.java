public class BisectionSolver implements RootSolver {
    public double tolerance;
    public int maxIterations;
    public BisectionSolver(double tolerance , int maxIterations) {
        this.maxIterations = maxIterations;
        this.tolerance = tolerance;
    }
    @Override
    public double solve(AbstractFunction f, double a, double b) {
        double fa = f.evaluate(a);
        double fb = f.evaluate(b);
        if(fa * fb >= 0) {
            throw new IllegalArgumentException("Function values at the endpoints must have opposite signs");
        }
        for(int i = 0;i<maxIterations;i++) {
            double c = (a+b) / 2;
            double fc = f.evaluate(c);
            if(Math.abs(fc) < tolerance || (b-a) /2 < tolerance) {
                return c ;
            }
            if(fa * fc <0) {
                b =c;
                fb = fc;

            } else {
                a = c;
                fa = fc;
            }
        }
        throw new RuntimeException("Bisection method did not converge");
    }
}
