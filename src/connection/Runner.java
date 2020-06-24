package connection;

import com.github.javafaker.Faker;

public class Runner {
    public static void main(String[] args) {
        DatabaseGeneration.generate(50, 50, 3, 70);
    }
}
