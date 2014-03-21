/**
 * @author t.j.
 * @version 2014-03
 *
 * inspired by:
 *  http://docs.oracle.com/javase/tutorial/java/annotations/QandE/answers.html
 */

public class MealTest {

    @Meal(name="breakfast", mainDish="cereal")
    @Meal(name="lunch", mainDish="pizza")
    @Meal(name="dinner", mainDish="salad")
    public void evaluateDiet() {}

}