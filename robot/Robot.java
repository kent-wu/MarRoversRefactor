package robot;

public class Robot {
    public static int X;
    public static int Y;
    //position
    public int x;
    public int y;
    //direction
    public char dir;

    public String control(String order) {
        char[] orders = order.toCharArray();
        for (char tmp : orders) {
            //ת��Ϊ��д��ĸ
            tmp = Character.toUpperCase(tmp);
            if (tmp == 'L' || tmp == 'R') {
                this.setDir(tmp);
            } else {
                this.move(tmp);
                if (this.checkError()) {
                    return "RIP";
                }
            }
        }
        //for end
        return this.x + " " + this.y + " " + this.dir;
    }

    private void setDir(char change) {
        if (change == 'L') {
            if (this.dir == 'N') {
                this.dir = 'W';
            } else if (this.dir == 'S') {
                this.dir = 'E';
            } else if (this.dir == 'W') {
                this.dir = 'S';
            } else if (this.dir == 'E') {
                this.dir = 'N';
            }
        } else {
            if (this.dir == 'N') {
                this.dir = 'E';
            } else if (this.dir == 'S') {
                this.dir = 'W';
            } else if (this.dir == 'W') {
                this.dir = 'N';
            } else if (this.dir == 'E') {
                this.dir = 'S';
            }
        }
    }

    private void move(char des) {
        if (des == 'M') {
            //NSWE
            if (this.dir == 'N') {
                this.y += 1;
            } else if (this.dir == 'S') {
                this.y -= 1;
            } else if (this.dir == 'W') {
                this.x -= 1;
            } else if (this.dir == 'E') {
                this.x += 1;
            }
        } else {
            if (this.dir == 'N') {
                this.y -= 1;
            } else if (this.dir == 'S') {
                this.y += 1;
            } else if (this.dir == 'W') {
                this.x += 1;
            } else if (this.dir == 'E') {
                this.x -= 1;
            }
        }
    }

    private boolean checkError() {
        if (this.x > X || this.x < 0 || this.y > Y || this.y < 0) {
            return true;
        }
        return false;
    }
}
