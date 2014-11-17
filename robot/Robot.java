package robot;

import java.util.HashMap;
import java.util.Map;

public class Robot {
    public static int x_bound;
    public static int y_bound;
    public int x;
    public int y;
    public char currentDirection;
    private int currentDirectionInt;
    private Map directionMap;
    public char[] direction = new char[]{'N', 'E', 'S', 'W'};
    public int[] x_moves = new int[]{0, 1, 0, -1};
    public int[] y_moves = new int[]{1, 0, -1, 0};

    public Robot() {
        directionMap = new HashMap();
        directionMap.put('N',0);
        directionMap.put('E',1);
        directionMap.put('S',2);
        directionMap.put('W',3);
    }
    
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

    public String controlRefactor(String orderString) {
        char[] orders = orderString.toCharArray();
        for (char order : orders) {
            order = Character.toUpperCase(order);
            switch (order) {
                case 'L':
                    turnLeftInt();
                    break;
                case 'R':
                    turnRightInt();
                    break;
                case 'M':
                    moveForwardInt();
                    break;
                case 'B':
                    moveBackInt();
                    break;
            }
            if (this.checkError()) {
                return "RIP";
            }

        }
        return x + " " + y + " " + direction[currentDirectionInt];
    }

    private void setCurrentDirection(char change) {
        if (change == 'L') {
            turnLeft();
        } else {
            turnRight();
        }
    }

    public void setCurrentDirectionInt(char currentDirection) {
        this.currentDirectionInt = (Integer) directionMap.get(currentDirection);
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

    public void turnLeftInt() {
        currentDirectionInt = (currentDirectionInt + 3) % 4;
    }

    public void turnRightInt() {
        currentDirectionInt = (currentDirectionInt + 1) % 4;
    }

    public void moveForwardInt() {
        x += x_moves[currentDirectionInt];
        y += y_moves[currentDirectionInt];
    }

    public void moveBackInt() {
        x -= x_moves[currentDirectionInt];
        y -= y_moves[currentDirectionInt];
    }

    private boolean checkError() {
        if (this.x > x_bound || this.x < 0 || this.y > y_bound || this.y < 0) {
            return true;
        }
        return false;
    }
}
