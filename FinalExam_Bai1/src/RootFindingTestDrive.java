import javax.swing.table.AbstractTableModel;

public class RootFindingTestDrive {
    public static void main(String[] args) {
        testRootSolver();


    }
    public static void testRootSolver() {
        AbstractFunction function = new UnivariateRealFunction(){
            MyMath myMath = new MyMath();
            public double evaluate(double x) {
                return myMath.sin(x) * x -3;
        }
        public double derative(double x) {
                return myMath.sin(x) + myMath.cos(x)*x; // Đạo hàm của sin(x) * x - 3 ;

        }
        };

        RootSolver secantSolver = new SecantSolver(1e-6, 100);
        RootSolver bisectionSolver = new BisectionSolver(1e-6, 100);
        RootSolver newtonRaphsonSolver = new NewtonRaphsonSolver(1e-6, 100);


        UnivariateRealRootFinding rootFinding;
        double x0  =1;
        double x1 = 2;
        while(function.evaluate(x0) * function.evaluate(x1) > 0 ) {
            x1+=1;
        }

        rootFinding = new UnivariateRealRootFinding(function , secantSolver);
        System.out.println(rootFinding.solve(x0,x1));


        rootFinding.setRootSolver(bisectionSolver);
        System.out.println(rootFinding.solve(x0,x1));


        rootFinding.setRootSolver(newtonRaphsonSolver);
        System.out.println(rootFinding.solve(x0,x1));



    }
}
