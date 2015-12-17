package uts.edu.eao;

import javax.ejb.Local;

@Local
public interface TestJpaLocal
	{
		public void TestSaveCus();
		public void TestSaveOrder();
	}
