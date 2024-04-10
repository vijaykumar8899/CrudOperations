import java.util.*;
import java.util.Calendar;
import java.util.Date;

public class test {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    Date startOfMonth = calendar.getTime();

    // Get the end date of the current month
    calendar.add(Calendar.MONTH, 1);
    calendar.add(Calendar.DATE, -1);
    Date endOfMonth = calendar.getTime();

    // Create and execute the query
    Query query = entityManager.createQuery("SELECT r FROM Registration r WHERE r.registrationDate BETWEEN :startOfMonth AND :endOfMonth");
    query.setParameter("startOfMonth", startOfMonth);
    query.setParameter("endOfMonth", endOfMonth);
    return query.getResultList();
}
