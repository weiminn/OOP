//does NOT compile
abstract class TestDifferenReturn implements Herbivore, HerbiHancock{
    //same signatures but different return types for eatPlants() in both interfaces
}

//does NOT compile
interface TestInter extends Herbivore, HerbiHancock{
    //same signatures but different return types for eatPlants() in both interfaces
}