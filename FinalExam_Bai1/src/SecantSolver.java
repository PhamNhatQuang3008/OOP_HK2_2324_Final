public class SecantSolver implements RootSolver {
    public double tolerance;
    public int maxIterations;
    public SecantSolver(double tolerance , int maxIterations) {
        this.maxIterations = maxIterations;
        this.tolerance = tolerance;

    }
    public double solve(AbstractFunction f , double x0 , double x1) { // Theo phương pháp Secant //
        double fx0 = f.evaluate(x0);
        double fx1 = f.evaluate(x1);
        for(int i = 0 ; i< maxIterations; i++) {
            if(Math.abs(fx1) < tolerance) {
                return x1;
            }
            double x2 = x1 - fx1 * ( x1-x0) / (fx1 - fx0) ;
            x0 = x1;
            fx0 = fx1;
            x1 = x2;
            fx1 = f.evaluate(x1);

        }
        throw new RuntimeException("Secant method did not converge");
    }
}
