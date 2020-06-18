import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static final String NAME_PU = "sales";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(NAME_PU);

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Engine engine = new Engine(entityManager);
//
//        engine.run();
    }
}
