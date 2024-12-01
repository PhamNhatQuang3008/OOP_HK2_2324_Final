public class UnivariateRealFunction implements AbstractFunction{
    public UnivariateRealFunction() {

    }

    @Override
    public double derivative(double x) {
        return x;
    }

    @Override
    public double evaluate(double x) {
        return 1;
    }
}
