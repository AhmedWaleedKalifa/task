package ejbs;



import javax.ejb.Stateful;
import javax.ejb.Stateless;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Stateful
@Entity
public class Calculation  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public float num1;
	public float num2;
	public char operation;
	public float getNum1() {
	return num1;
	}
	public float getNum2() {
		return num2;
	}
	public char getOperation() {
		return operation;
	}
}
