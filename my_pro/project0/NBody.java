import java.io.*;
import java.util.*;

public class NBody{

    public static double readRadius(String filePath){
       In in = new In(filePath);
       
       String noOfPlanets = in.readString();
       String radius = in.readString();
       double rad = Double.parseDouble(radius);
       return rad;


    }
    public static Planet[] readPlanets(String filePath){
        In in = new In(filePath);

        double noOfPlanets = in.readDouble();
        double radius = in.readDouble();
        Planet[] plan = new Planet[(int)noOfPlanets];
        for(int i=0; i<plan.length; i++){
            double xpos = in.readDouble();
            double ypos = in.readDouble();
            double xvel = in.readDouble();
            double yvel = in.readDouble();
            double m =  in.readDouble();
            String name = in.readString();
            plan[i] = new Planet(xpos,ypos,xvel,yvel,m,name);
            
        }
        return plan;    
    } 

    public static void drawBackGround(double radius){
        StdDraw.setScale(-radius,radius);

        StdDraw.clear();
        StdDraw.picture(0, radius, "./images/starfield.jpg");

    }

    public static void main(String[] args){
        double time = 0;
        
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double planetRadius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        //System.out.println(planets.length);
        Double[] xForces = new Double[10000];
        Double[] yForces = new Double[10000];
        while(time<= T){
        for(int i=0; i < planets.length; i++){
            xForces[i] = planets[i].calcNetForceExertedByX(planets);
            yForces[i] = planets[i].calcNetForceExertedByY(planets);
        }
        for(int i=0; i < planets.length; i++ ){
            planets[i].update(dt,xForces[i],yForces[i]);
        }
        drawBackGround(planetRadius);
        for(Planet p : planets ){
            p.draw();
        }
        StdDraw.show(10);
        time= time+dt;

        }
    }
}