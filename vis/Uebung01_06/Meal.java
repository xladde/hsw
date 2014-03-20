/**
 * @author t.j.
 * @version 2014-03
 */
public @interface Meal {

}

@Meal("breakfast", mainDish="cereal")
@Meal("lunch", mainDish="pizza")
@Meal("dinner", mainDish="salad")

public void evaluateDiet() {}