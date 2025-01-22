public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;

    }
    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName=b.imgFileName;
    }
    public double calcDistance(Body b1)
    {
        double dx = b1.xxPos - this.xxPos;
        double dy = b1.yyPos - this.yyPos;
        double r = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
        return r;

    }
    public double calcForceExertedBy(Body b2)
    {
        double m1 = this.mass;
        double m2 = b2.mass;
        double G  = 6.67e-11;
        double r = this.calcDistance(b2);
        double F = (G*m1*m2)/(r*r);
        return F;

    }
    public double calcForceExertedByX(Body bx)
    {
        double F = this.calcForceExertedBy(bx);
        double r = this.calcDistance(bx);
        double dx = bx.xxPos - this.xxPos;
        double Fx = F*dx/r;
        return Fx;

    }
    public double calcForceExertedByY(Body by)
    {
        double F = this.calcForceExertedBy(by);
        double r = this.calcDistance(by);
        double dy= by.yyPos - this.yyPos;
        double Fy = F*dy/r;
        return Fy;
    }
    public double calcNetForceExertedByX(Body[] b)
    {
        int len = b.length;
        double netx = 0;
        for(int i=0;i<len;i++)
        {
            if(this.equals(b[i]))
            {
                continue;
            }
            else {
                netx+= this.calcForceExertedByX(b[i]);
            }


        }
        return netx;
    }
    public double calcNetForceExertedByY(Body[] b)
    {
        int len = b.length;
        double nety = 0;
        for(int i=0;i<len;i++)
        {
            if(this.equals(b[i]))
            {
                continue;
            }
            nety+= this.calcForceExertedByY(b[i]);

        }
        return nety;
    }
    public void update(double dt,double fX,double fY)
    {
        double ax = fX/this.mass;
        double ay = fY/this.mass;
        this.xxVel= this.xxVel+ax*dt;
        this.yyVel= this.yyVel+ay*dt;
        this.xxPos = this.xxPos + dt*this.xxVel;
        this.yyPos = this.yyPos + dt*this.yyVel;
    }
    public  void draw()
    {
        String filename="images/"+this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, filename);
    }



}
