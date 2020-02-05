import sun.rmi.runtime.Log;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main
{
    static Robot robot;

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        int[] answers = Answers.answers19;

        for (int j = 0; j < 200; j++)
        {
            try
            {
                robot = new Robot();

                robot.delay(5000);

                if (j == 0)
                {
                    altTab(robot);
                }

                if (j % 10 == 0)
                {
                    if (j != 0)
                    {
                        refreshPage(robot);
                        pageUp(robot);
                    }
                }

                //moveMouse(robot, 845, 650); // X, Y - ПЕРВАЯ ПАНЕЛЬКА ТЕСТА
                //moveMouse(robot, 1170, 650); // X, Y - ВТОРАЯ ПАНЕЛЬКА ТЕСТА
                //moveMouse(robot, 1495, 650); // X, Y - ТРЕТЬЯ ПАНЕЛЬКА ТЕСТА
                moveMouse(robot, 845, 830); // X, Y - ЧЕТВЁРТАЯ ПАНЕЛЬКА ТЕСТА
                //moveMouse(robot, 1170, 830); // X, Y - ПЯТАЯ ПАНЕЛЬКА ТЕСТА
                //moveMouse(robot, 1495, 830); // X, Y - ШЕСТАЯ ПАНЕЛЬКА ТЕСТА
                //moveMouse(robot, 845, 1000); // X, Y - СЕДЬМАЯ ПАНЕЛЬКА ТЕСТА
                //moveMouse(robot, 1170, 1000); // X, Y - ВОСЬМАЯ ПАНЕЛЬКА ТЕСТА

                robot.delay(25);
                clickMouse(robot, 2);

                robot.delay(5000);

                solveTest(robot, answers);
                robot.delay(500);

                moveMouse(robot, 1385, 153); // ЗАКРЫТЬ ТЕСТ
                robot.delay(25);
                clickMouse(robot, 1);

                pageUp(robot);
            }

            catch (AWTException e)
            {
                e.printStackTrace();
            }
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);
    }

    public static void altTab(Robot r)
    {
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_TAB);

        r.keyRelease(KeyEvent.VK_ALT);
        r.keyRelease(KeyEvent.VK_TAB);
    }

    public static void refreshPage(Robot r)
    {
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_F5);

        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_F5);

        r.delay(10000);
    }

    public static void pageUp(Robot r)
    {
        r.delay(1000);
        r.keyPress(KeyEvent.VK_PAGE_UP);
        r.delay(10);
        r.keyRelease(KeyEvent.VK_PAGE_UP);
        r.delay(25);
    }

    public static void moveMouse(Robot r, int X, int Y)
    {
        r.mouseMove(X, Y);
    }

    public static void  clickMouse(Robot r, int number){
        int mouse = InputEvent.BUTTON1_MASK;

        for(int i = 0; i < number; i++)
        {
            r.mousePress(mouse);
            r.delay(100);
            r.mouseRelease(mouse);
        }
    }

    public static void  solveTest(Robot r, int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            r.delay(20);
            r.keyPress(a[i]);
            r.keyRelease(a[i]);
            r.keyPress(a[i]);
            r.keyRelease(a[i]);
            r.keyPress(KeyEvent.VK_SPACE);
            r.keyRelease(KeyEvent.VK_SPACE);
        }
    }
}
