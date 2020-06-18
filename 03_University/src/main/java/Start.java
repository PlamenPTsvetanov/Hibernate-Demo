import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Start {
    public static final String NAME_PU = "university";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(NAME_PU);

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Engine engine = new Engine(entityManager);
//
//        engine.run();
    }
}


