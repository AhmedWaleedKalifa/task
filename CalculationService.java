package App;


import java.util.List;
import  javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import ejbs.Calculation;

@Stateful
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("app")
public class CalculationService{
	@PersistenceContext(unitName="hello")
	private EntityManager em;
	 
@EJB
Calculation c;
@POST
@Path("/calc")
public float calculate(Calculation c1) {
	
	em.persist(c1);
	float result=0;
	if(c1.getOperation()=='+') {
		result=c1.getNum1()+c1.getNum2();
	}else if(c1.getOperation()=='-') {
		result=c1.getNum1()-c1.getNum2();
	
	}
	else if(c1.getOperation()=='/') {
		result=c1.getNum1()/c1.getNum2();
	}
	else if(c1.getOperation()=='*') {
		result=c1.getNum1()*c1.getNum2();
	}
	return result;
}
@GET
@Path("/calculation")
public List<Calculation> getCalculation() {
	String simpleQuery="SELECT num1,num2,operation FROM Calculation";
	Query query=em.createQuery(simpleQuery);
	List<Calculation> list=query.getResultList();
	return list;
	
}

}
