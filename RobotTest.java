import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import robot.Robot;

public class RobotTest{

    Robot robot;

    @Before
    public void setUp(){
        robot = new Robot();
        robot.X = 5;
        robot.Y = 5;
    }

    @Test
    public void should_be_1_3_N_after_excute_LMLMLMLMM(){
        robot.x = 1;
        robot.y = 2;
        robot.dir = 'N';
        String actualResult = robot.control("LMLMLMLMM");
        Assert.assertEquals("1 3 N",actualResult);
    }

    @Test
    public void should_be_3_3_E_after_excute_MMRMMRMRRM(){
        robot.x = 3;
        robot.y = 3;
        robot.dir = 'E';
        String actualResult = robot.control("MMRMMRMRRM");
        Assert.assertEquals("5 1 E",actualResult);
    }

    @Test
    public void should_be_RIP_after_excute_MMM(){
        robot.x = 4;
        robot.y = 4;
        robot.dir = 'N';
        String actualResult = robot.control("MMM");
        Assert.assertEquals("RIP",actualResult);
    }

    @Test
    public void should_be_1_3_N_after_excute_MMB(){
        robot.x = 1;
        robot.y = 2;
        robot.dir = 'N';
        String actualResult = robot.control("MMB");
        Assert.assertEquals("1 3 N",actualResult);
    }
}
