package uts.edu.bean;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Test
 */
@Stateless(mappedName = "ejb/Test")
public class Test implements TestLocal {

    /**
     * Default constructor. 
     */
    public Test() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Hello() {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}

}
