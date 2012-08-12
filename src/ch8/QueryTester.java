package ch8;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import persistence.JPAUtil;

public class QueryTester {


public static void main(String[] args) throws Exception {
	// Start EntityManagerFactory
    EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
    
    // First unit of work
    EntityManager em = emf.createEntityManager();
    //Select clauses
    //String query = "select m from Message m";
    //String query = "select d from Department d";
    //String query = "select d from Department d where d.name='QA'";
    //String query = "select e.name,e.salary, e.department.name from Employee e";
    //String query = "select a from Address a";
    //String query = "select NEW ch8.EmployeeConstructor(e.name,e.salary, e.department.name) from Employee e";
    //String query = "select p from Project p where p.employees is empty";
    //String query = "select e.name, e.phones from Employee e";
    
    //From clauses
    //String query = "SELECT p FROM Employee e JOIN e.phones p";
    //String query = "SELECT p FROM Employee e JOIN e.projects p where p.name = 'DesignProj1'";
    //String query = "SELECT e,d FROM Employee e LEFT JOIN e.department d ";
    //String query = "SELECT e FROM Employee e JOIN FETCH e.address a ";
    
    //Where clause
    //String query = "SELECT e FROM Employee e WHERE e.salary > 4000 ";
    //String query = "SELECT e FROM Employee e WHERE e.salary BETWEEN 4500 AND 5000";
    //String query = "SELECT e.name, e.department.name FROM Employee e WHERE e.department.name LIKE '____A%'";
    
    //Update 
    //String query = "UPDATE Employee e SET e.salary = 12000 WHERE e.salary = 6000";
    
    //Delete
    String query = "DELETE FROM Employee e where e.department IS NULL";
    
    try {
        List result = em.createQuery(query).getResultList();
        if (result.size() > 0) {
            int count = 0;
            for (Object o : result) {
                System.out.print(++count + " ");
                printResult(o);
            }
        } else {
            System.out.println("0 results returned");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    
    
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            System.out.print("JP QL> ");
            String query = reader.readLine();
            if (query.equals("quit")) {
                break;
            }
            if (query.length() == 0) {
                continue;
            }

            try {
                List result = em.createQuery(query).getResultList();
                if (result.size() > 0) {
                    int count = 0;
                    for (Object o : result) {
                        System.out.print(++count + " ");
                        printResult(o);
                    }
                } else {
                    System.out.println("0 results returned");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    private static void printResult(Object result) throws Exception {
        if (result == null) {
            System.out.print("NULL");
        } else if (result instanceof Object[]) {
            Object[] row = (Object[]) result;
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                printResult(row[i]);
            }
            System.out.print("]");
        } else if (result instanceof Long ||
                   result instanceof Double ||
                   result instanceof String) {
            System.out.print(result.getClass().getName() + ": " + result);
        } else {
            System.out.print(ReflectionToStringBuilder.toString(result,ToStringStyle.SHORT_PREFIX_STYLE));
        }
        System.out.println();
    }
}