package model;
import java.util.ArrayList;

public class BulletPool {
    ArrayList<Bullet> bullet_list = new ArrayList<Bullet>();
    private int num = 0;

    public BulletPool(){
        for(int i=0; i<100; i++){
            bullet_list.add(new Bullet(100,100));
        }
    }

    public Bullet getBullet(int x, int y, int dx, int dy){
        Bullet bullet = bullet_list.get(num);
        bullet.reset(0,0,0,2);
        num = (num+1)% bullet_list.size();
        return bullet;
    }

}
