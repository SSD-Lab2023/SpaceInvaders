package model;
import java.util.ArrayList;

public class BulletPool {
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private int num = 0;

    public BulletPool(){
        for(int i=0; i<100; i++){
            bullets.add(new Bullet(100,100));
        }
    }

    public Bullet getBullet(int x, int y, int dx, int dy){
        Bullet bullet = bullets.get(num);
        bullet.reset(0,0,0,2);
        num = (num+1)% bullets.size();
        return bullet;
    }

    public void addBullet(Bullet bullet){
        bullets.add(bullet);
    }

}
