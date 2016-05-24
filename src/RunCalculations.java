import Jama.Matrix;

import java.util.Arrays;
import java.util.LinkedList;

public class RunCalculations {
    public static void main(String[] args) {
        LinkedList<double[]> linAccSamples = new LinkedList<>();
        LinkedList<double[]> gyroSamples = new LinkedList<>();
        linAccSamples.add(new double[] {0.6199161410331726,-1.840886116027832,4.363898277282715});
        linAccSamples.add(new double[] {-1.295964002609253,1.3011603355407715,1.976028323173523});
        linAccSamples.add(new double[] {-1.0550503730773926,1.2519176006317139,-1.0213059186935425});
        linAccSamples.add(new double[] {1.2163758277893066,0.7365642189979553,-2.471317768096924});
        linAccSamples.add(new double[] {1.695397973060608,0.42944473028182983,-2.4582371711730957});
        linAccSamples.add(new double[] {0.42726776003837585,0.16897183656692505,-1.2394062280654907});
        linAccSamples.add(new double[] {-0.2335493564605713,0.31944385170936584,0.7737187743186951});
        linAccSamples.add(new double[] {-0.1027030199766159,0.18706630170345306,0.9212544560432434});
        linAccSamples.add(new double[] {0.18074658513069153,-0.13008154928684235,0.5268833637237549});
        linAccSamples.add(new double[] {0.48971420526504517,-0.3674953579902649,0.07739304006099701});
        linAccSamples.add(new double[] {0.749410092830658,-0.40540364384651184,0.06440963596105576});
        linAccSamples.add(new double[] {0.6956585049629211,-0.32503655552864075,0.20324644446372986});
        linAccSamples.add(new double[] {0.7970908880233765,-0.22689619660377502,0.2895505130290985});
        linAccSamples.add(new double[] {0.8320264220237732,-0.014623276889324188,0.4061398506164551});
        linAccSamples.add(new double[] {0.7162103056907654,0.023281799629330635,0.6019318699836731});;

        gyroSamples.add(new double[] {-0.9426119923591614,-0.6642239689826965,-0.5274720191955566});
        gyroSamples.add(new double[] {0.7069590091705322,-0.2857140004634857,0.15995100140571594});
        gyroSamples.add(new double[] {1.1025630235671997,-0.26129400730133057,0.5873010158538818});
        gyroSamples.add(new double[] {0.7142850160598755,-0.16361400485038757,0.6336989998817444});
        gyroSamples.add(new double[] {0.07936500012874603,-0.1892549991607666,0.31013399362564087});
        gyroSamples.add(new double[] {-0.4175820052623749,-0.12209999561309814,0.06227099895477295});
        gyroSamples.add(new double[] {-0.3565320074558258,0.15995100140571594,0.167276993393898});
        gyroSamples.add(new double[] {-0.07692299783229828,0.2332109957933426,0.2808299958705902});
        gyroSamples.add(new double[] {0.1562879979610443,0.2649570107460022,0.34432199597358704});
        gyroSamples.add(new double[] {0.2527469992637634,0.28815600275993347,0.33821699023246765});
        gyroSamples.add(new double[] {0.22100099921226501,0.2869350016117096,0.2747249901294708});
        gyroSamples.add(new double[] {0.14285700023174286,0.13064700365066528,0.15018299221992493});
        gyroSamples.add(new double[] {-0.050060998648405075,0.020756999030709267,0.11843699961900711});
        gyroSamples.add(new double[] {-0.11233200132846832,-0.040293000638484955,0.08546999841928482});
        gyroSamples.add(new double[] {-0.12576299905776978,-0.07203900068998337,0.08546999841928482});

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
        System.out.println(Arrays.toString(features.getMean(linAccSamples))); // okay
        System.out.println(Arrays.toString(features.getStdDev(linAccSamples))); // okay
        System.out.println(Arrays.toString(features.getSkewness(linAccSamples))); // need to change scipy call:bias=False
        System.out.println(Arrays.toString(features.getKurtosis(linAccSamples))); // need to change scipy call: bias=False
        System.out.println(Arrays.toString(features.getRMS(linAccSamples)));
        System.out.println(Arrays.toString(features.getP2p(linAccSamples)));
        System.out.println(Arrays.toString(features.getMin(linAccSamples)));
        System.out.println(Arrays.toString(features.getMax(linAccSamples)));
        System.out.println(features.getL1Norm(linAccMatrix)); // okay
        System.out.println(features.getInfNorm(linAccMatrix)); // okay
        System.out.println(features.getFroNorm(linAccMatrix)); // okay, difference is negligible.
        System.out.println(Arrays.toString(features.getPearsonCoeff(linAccSamples, gyroSamples))); // okay
        System.out.println(features.getAngle(linAccSamples));
//        System.out.println(features.getTapOccurrenceFeatures());
    }
}
