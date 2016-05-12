import Jama.Matrix;

import java.util.Arrays;
import java.util.LinkedList;

public class RunCalculations {
    public static void main(String[] args) {
        LinkedList<double[]> linAccSamples = new LinkedList<>();
        LinkedList<double[]> gyroSamples = new LinkedList<>();
        linAccSamples.add(new double[] {-0.5762239694595337, 0.16243454813957214,0.0730307474732399});
        linAccSamples.add(new double[] {-0.5722370743751526, 0.15929098427295685,0.049130234867334366});
        linAccSamples.add(new double[] {-0.5722819566726685, 0.16261398792266846,0.3850666582584381});

        gyroSamples.add(new double[] {0.021978000178933144, 0.23076899349689484,-0.41391900181770325});
        gyroSamples.add(new double[] {0.020756999030709267, 0.27838799357414246,-0.40903499722480774});
        gyroSamples.add(new double[] {0.07203900068998337, 0.3638579845428467, -0.40659299492836});

        // Use sample values for the Jama Matrix
        double[][] linAccArray = new double[linAccSamples.size()][];
        for (int i = 0; i < linAccSamples.size(); i++) {
            linAccArray[i] = linAccSamples.get(i);
        }
        Matrix linAccMatrix = new Matrix(linAccArray);

        double[][] gyroArray = new double[gyroSamples.size()][];
        for (int i = 0; i < gyroSamples.size(); i++) {
            gyroArray[i] = gyroSamples.get(i);
        }
        Matrix gyroMatrix = new Matrix(gyroArray);

        Features features = new Features(linAccSamples, gyroSamples);
//        System.out.println(Arrays.toString(features.getMean(linAccSamples))); // okay
//        System.out.println(Arrays.toString(features.getStdDev(linAccSamples))); // okay
//        System.out.println(Arrays.toString(features.getSkewness(linAccSamples))); // skewness different
//        System.out.println(Arrays.toString(features.getKurtosis(linAccSamples))); // kurtosis returns NaN
//        System.out.println(features.getL1Norm(linAccMatrix)); // okay
//        System.out.println(features.getInfNorm(linAccMatrix)); // okay
//        System.out.println(features.getFroNorm(linAccMatrix)); // okay, difference is negligible.
//        System.out.println(Arrays.toString(features.getPearsonCoeff(linAccSamples, gyroSamples))); // okay

    }
}
