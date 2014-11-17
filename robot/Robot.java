package robot;

import java.util.HashMap;
import java.util.Map;

public class Robot {
    public static int x_bound;
    public static int y_bound;
    public int x;
    public int y;
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

    public void setCurrentDirectionInt(char currentDirection) {
        this.currentDirectionInt = (Integer) directionMap.get(currentDirection);
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
