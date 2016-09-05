public class Planet{
    //Instance Variables
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    

    //constructors
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }

   public double calcDistance(Planet a){
        double dx = a.xxPos - this.xxPos;
        double dy = a.yyPos - this.yyPos;
        double r = Math.sqrt((dx*dx)+(dy*dy));
        return r;

   }

   public double calcForceExertedBy(Planet a){
        double dx,dy;
        if(a.xxPos > this.xxPos){
             dx = a.xxPos - this.xxPos;
        }else{
             dx = this.xxPos - a.xxPos;
        }

        if(a.yyPos > this.yyPos){
             dy = a.yyPos - this.yyPos;
        }else{
             dy = this.yyPos - a.yyPos;
        }

        double r = Math.sqrt((dx*dx)+(dy*dy));

        double force = ((6.67e-11)*this.mass*a.mass)/(r*r);
        return force;
   }

   public double calcForceExertedByX(Planet a){
        double force = this.calcForceExertedBy(a);
        double r = this.calcDistance(a);
        double forceInX = (force * (a.xxPos - this.xxPos))/ r ;
        return forceInX;
   }

   public double calcForceExertedByY(Planet a){
        double force = this.calcForceExertedBy(a);
        double r = this.calcDistance(a);
        double forceInY = (force * (a.yyPos - this.yyPos))/ r ;
        return forceInY;
   } 

   public double calcNetForceExertedByX(Planet[] a){
        double netForceX = 0;
        for(Planet i : a){
            if(i.equals(this) == false){
                netForceX = this.calcForceExertedByX(i) + netForceX;
            }
        }
        return netForceX;
   }

    public double calcNetForceExertedByY(Planet[] a){
        double netForceY = 0;
        for(Planet i : a){
            if(i.equals(this) == false){
                netForceY = this.calcForceExertedByY(i) + netForceY;
            }
        }
        return netForceY;
   }

   public void update(double dt, double xForce, double yForce){
        double xAcc = xForce/this.mass;
        double yAcc = yForce/this.mass;
        this.xxVel = this.xxVel + xAcc*dt;
        this.yyVel = this.yyVel + yAcc*dt;
        this.xxPos = this.xxPos + this.xxVel*dt;
        this.yyPos = this.yyPos + this.yyVel*dt;
   }

   public void draw(){
        String filepath = "./images/" + this.imgFileName;
        StdDraw.picture(this.xxPos,this.yyPos, filepath);
   }

 

}