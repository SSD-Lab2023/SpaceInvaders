package model;
import java.util.ArrayList;

public class BulletPool {
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<LaserBeam> lasers = new ArrayList<LaserBeam>();
    private int num = 0;

    public BulletPool(){
        for(int i=0; i<100; i++){
            bullets.add(new Bullet(100,100));
            lasers.add(new LaserBeam(100, 100));
        }
    }

    public Bullet getBullet(int x, int y, int dx, int dy){
        Bullet bullet = bullets.get(num);
        bullet.reset(x,y,dx,dy);
        num = (num+1)% bullets.size();
        return bullet;
    }
    public void releaseBullet(Bullet bullet) {
        bullets.add(bullet);
    }


    public LaserBeam getLaser(int x, int y, int dx, int dy) {
        LaserBeam laser = lasers.get(num);
        laser.reset(x,y,dx,dy);
        num = (num+1)% lasers.size();
        return laser;
    }

}
