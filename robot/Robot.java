package robot;

import java.util.Map;

public class Robot {
    public static int x_bound;
    public static int y_bound;
    public int x;
    public int y;
    public char currentDirection;
    private int currentDirectionInt;
    private Map directionMap;
    public char[] direction = new char[]{'N','E','S','W'};

    public String control(String order) {
        char[] orders = order.toCharArray();
        for (char tmp : orders) {
            tmp = Character.toUpperCase(tmp);
            if (tmp == 'L' || tmp == 'R') {
                this.setCurrentDirection(tmp);
            } else {
                this.move(tmp);
                if (this.checkError()) {
                    return "RIP";
                }
            }
        }
        return this.x + " " + this.y + " " + this.currentDirection;
    }

    private void setCurrentDirection(char change) {
        if (change == 'L') {
            turnLeft();
        } else {
            turnRight();
        }
    }

    public void setCurrentDirectionInt(int currentDirection) {
        this.currentDirectionInt = (Integer)directionMap.get(currentDirection);
    }

    private void move(char des) {
        if (des == 'M') {
            moveForward();
        } else {
            moveBack();
        }
    }

    private void turnRight() {
        if (this.currentDirection == 'N') {
            this.currentDirection = 'E';
        } else if (this.currentDirection == 'S') {
            this.currentDirection = 'W';
        } else if (this.currentDirection == 'W') {
            this.currentDirection = 'N';
        } else if (this.currentDirection == 'E') {
            this.currentDirection = 'S';
        }
    }

    private void turnLeft() {
        if (this.currentDirection == 'N') {
            this.currentDirection = 'W';
        } else if (this.currentDirection == 'S') {
            this.currentDirection = 'E';
        } else if (this.currentDirection == 'W') {
            this.currentDirection = 'S';
        } else if (this.currentDirection == 'E') {
            this.currentDirection = 'N';
        }
    }

    private void moveBack() {
        if (this.currentDirection == 'N') {
            this.y -= 1;
        } else if (this.currentDirection == 'S') {
            this.y += 1;
        } else if (this.currentDirection == 'W') {
            this.x += 1;
        } else if (this.currentDirection == 'E') {
            this.x -= 1;
        }
    }

    private void moveForward() {
        if (this.currentDirection == 'N') {
            this.y += 1;
        } else if (this.currentDirection == 'S') {
            this.y -= 1;
        } else if (this.currentDirection == 'W') {
            this.x -= 1;
        } else if (this.currentDirection == 'E') {
            this.x += 1;
        }
    }

    private boolean checkError() {
        if (this.x > x_bound || this.x < 0 || this.y > y_bound || this.y < 0) {
            return true;
        }
        return false;
    }
}
