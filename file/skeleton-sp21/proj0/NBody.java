public class NBody
{
    public static double readRadius(String path)
    {
        In in = new In(path);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    public static Body[] readBodies(String path)
    {
        In in = new In(path);
        int N = in.readInt();
        double radius = in.readDouble();
        Body[] b = new Body[N];
        int i = 0;
        while(!in.isEmpty() && i<N)
        {

            double xxPos=in.readDouble();
            double yyPos=in.readDouble();
            double xxVel=in.readDouble();
            double yyVel=in.readDouble();
            double mass=in.readDouble();
            String  imgFileName=in.readString();
            b[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
            i++;

        }
        return b;
    }
    public static void main(String[] args)
    {
        double T=Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename =args[2];
        double R = readRadius(filename);
        Body b[] = readBodies(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1200,800);
        StdDraw.setScale(-R,R);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for(Body body: b)
        {
            body.draw();
        }
        StdDraw.show();
        double time = 0;
        while(time<=T)
        {

            int len = b.length;
            double xForces[]=new double[len];
            double yForces[]=new double[len];
            for(int i=0;i<len;i++)
            {
                xForces[i] = b[i].calcNetForceExertedByX(b);
                yForces[i] = b[i].calcNetForceExertedByY(b);


            }
            for(int j=0;j<len;j++)
            {
                b[j].update(dt,xForces[j],yForces[j]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(Body body: b)
            {
                body.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

    }











}
