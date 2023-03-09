package samyak.jain.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* samyak.jain.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* samyak.jain.aopdemo.dao.*.get*(..))")
	public void getter() {}

	@Pointcut("execution(* samyak.jain.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter()||setter())")
	public void forDaoPackageNoGetterSetter() {}
}
