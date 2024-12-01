public class NewtonRaphsonSolver implements RootSolver{
    public double tolerance;
    public int maxIterations;
    public NewtonRaphsonSolver(double tolerance , int maxIterations) {
        this.maxIterations = maxIterations;
        this.tolerance = tolerance;
    }
    @Override
    public double solve(AbstractFunction f, double x0, double x1) {
        for (int i = 0; i < maxIterations; i++) {
            double fx = f.evaluate(x0);
            double dfx = f.derivative(x0);
            if(Math.abs(fx) < tolerance) {
                return x0;
            }
            x0 = x0-fx / dfx;
        }
        throw new RuntimeException("Newton-Raphson method did not converge");
    }
}
