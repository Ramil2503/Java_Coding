package HW3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> planets = new ArrayList<>();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Neptune");
        planets.add("Pluto");

        List<String> randomPlanets = generateRandomPlanets(planets, 10);

        System.out.println("Randomly generated list of planets: " + planets);

        for (String planet : planets) {
            int frequency = Collections.frequency(randomPlanets, planet);
            System.out.println(planet + ": " + frequency);
        }
    }

    private static List<String> generateRandomPlanets(List<String> planets, int count) {
        List<String> randomPlanets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomIndex = (int) (Math.random() * planets.size());
            randomPlanets.add(planets.get(randomIndex));
        }
        return randomPlanets;
    }
}
